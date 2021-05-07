package Student.Panel;

import Basic.Command;
import Student.Bean.Student;
import Student.Frame.MainFrame;
import Student.Function.*;
import Student.Function.MyDialog.UploadPaperDialog;
import Student.Panel.QuestionPanel.*;
import Teacher.Bean.Paper;
import Teacher.Bean.Question.*;
import Teacher.Util.AdapterAndHelper.GBC;
import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

import static Basic.Login.HOST;
import static Basic.Login.PORT;

public class PaperPanel extends JPanel {
    private final MainFrame mainFrame;
    private final PaperRightPanel paperRightPanel;
    private final PaperLeftPanel paperLeftPanel;
    private final Paper paper;

    public PaperPanel(MainFrame mainFrame, Paper paper) {
        this.mainFrame = mainFrame;
        this.paper = paper;

        setLayout(null);
        setBounds(0, 0, 1600, 860);
        setBackground(Color.white);

        NetGetPreviewQuestions netGetPreviewQuestions = new NetGetPreviewQuestions(paper.getQuestions());
        Question_Choice[] choices = netGetPreviewQuestions.getChoices();
        Question_MultiChoice[] multiChoices = netGetPreviewQuestions.getMultiChoices();
        Question_Judge[] judges = netGetPreviewQuestions.getJudges();
        Question_Subjective[] subjectives = netGetPreviewQuestions.getSubjective();

        PagesPanel[] pagesPanels = new PagesPanel[(int) Math.ceil(choices.length + multiChoices.length + judges.length + subjectives.length / 10.0)];
        int[] pageQuestionsNum = new int[pagesPanels.length]; // 每页的题目个数
        //添加题
        if (choices.length > 0)
            pagesPanelsFixed(pagesPanels, pageQuestionsNum, choices, "choice");
        if (multiChoices.length > 0)
            pagesPanelsFixed(pagesPanels, pageQuestionsNum, multiChoices, "multi");
        if (judges.length > 0)
            pagesPanelsFixed(pagesPanels, pageQuestionsNum, judges, "judge");
        if (subjectives.length > 0)
            pagesPanelsFixed(pagesPanels, pageQuestionsNum, subjectives, "subjective");


        paperLeftPanel = new PaperLeftPanel(pagesPanels);
        PaperJSP paperJSP = new PaperJSP(paperLeftPanel);
        add(paperJSP);

        paperRightPanel = new PaperRightPanel(this);
        add(paperRightPanel);
        setVisible(true);
        mainFrame.examStart(this);
    }


    public UploadPaperDialog getUploadPaperDialog() {
        return paperRightPanel.getUploadPaperDialog();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public PaperLeftPanel getPaperLeftPanel() {
        return paperLeftPanel;
    }

    public Paper getPaper() {
        return paper;
    }

    public void uploadAnswer(){
        try {
            new NetUploadAnswer(mainFrame.getStudent(),paper,paperLeftPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class NetUploadAnswer{
        public NetUploadAnswer(Student student,Paper paper, PaperLeftPanel paperLeftPanel) throws IOException {
            Socket socket = new Socket(HOST, PORT);
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            dos.writeUTF(Command.UPLOAD_ANSWER);
            dos.flush();

            opw.println(JSON.toJSONString(student));
            opw.println(JSON.toJSONString(paper));
            opw.println(JSON.toJSONString(paperLeftPanel.getAnswer()));

            dis.readUTF();
        }
    }
    private static class NetGetPreviewQuestions {
        Question_Choice[] choices;
        Question_MultiChoice[] multiChoices;
        Question_Judge[] judges;
        Question_Subjective[] subjective;

        public NetGetPreviewQuestions(String questionString) {
            try {
                Socket socket = new Socket(HOST, PORT);
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                PrintWriter opw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                BufferedReader obr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                dos.writeUTF(Command.GET_QUESTION_PREVIEW);
                dos.flush();

                opw.println(questionString);
                choices = JSON.parseObject(obr.readLine(), Question_Choice[].class);
                multiChoices = JSON.parseObject(obr.readLine(), Question_MultiChoice[].class);
                judges = JSON.parseObject(obr.readLine(), Question_Judge[].class);
                subjective = JSON.parseObject(obr.readLine(), Question_Subjective[].class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Question_Choice[] getChoices() {
            return choices;
        }

        public Question_MultiChoice[] getMultiChoices() {
            return multiChoices;
        }

        public Question_Judge[] getJudges() {
            return judges;
        }

        public Question_Subjective[] getSubjective() {
            return subjective;
        }
    }

    private static void pagesPanelsFixed(PagesPanel[] pagesPanels, int[] pageQuestionsNum, Question[] questions, String type) {
        int page = 0;
        while (pageQuestionsNum[page] == 10)
            page++;
        int count = pageQuestionsNum[page];
        Question[] pageQuestions;
        if (questions.length>9-count)
            pageQuestions = Arrays.copyOfRange(questions, 0, 9 - count);
        else
            pageQuestions = Arrays.copyOfRange(questions,0,questions.length);
        switch (type) {
            case "choice":
                pagesPanels[page].addChoiceQuestions((Question_Choice[]) pageQuestions);
                break;
            case "multi":
                pagesPanels[page].addMultiChoiceQuestions((Question_MultiChoice[]) pageQuestions);
                break;
            case "judge":
                pagesPanels[page].addJudgeQuestions((Question_Judge[]) pageQuestions);
                break;
            case "subjective":
                pagesPanels[page].addSubjectiveQuestions((Question_Subjective[]) pageQuestions);
                break;
        }
        pageQuestionsNum[page] = 10;
        page++;
        for (int i = count; i < questions.length; i++) {
            if (count + 10 < questions.length) {
                pageQuestions = Arrays.copyOfRange(questions, count, count += 10);
                switch (type) {
                    case "choice":
                        pagesPanels[page].addChoiceQuestions((Question_Choice[]) pageQuestions);
                        break;
                    case "multi":
                        pagesPanels[page].addMultiChoiceQuestions((Question_MultiChoice[]) pageQuestions);
                        break;
                    case "judge":
                        pagesPanels[page].addJudgeQuestions((Question_Judge[]) pageQuestions);
                        break;
                    case "subjective":
                        pagesPanels[page].addSubjectiveQuestions((Question_Subjective[]) pageQuestions);
                        break;
                }
                pageQuestionsNum[page] = 10;
                page++;
            } else {
                pageQuestions = Arrays.copyOfRange(questions, count, questions.length);
                switch (type) {
                    case "choice":
                        pagesPanels[page].addChoiceQuestions((Question_Choice[]) pageQuestions);
                        break;
                    case "multi":
                        pagesPanels[page].addMultiChoiceQuestions((Question_MultiChoice[]) pageQuestions);
                        break;
                    case "judge":
                        pagesPanels[page].addJudgeQuestions((Question_Judge[]) pageQuestions);
                        break;
                    case "subjective":
                        pagesPanels[page].addSubjectiveQuestions((Question_Subjective[]) pageQuestions);
                        break;
                }
                pageQuestionsNum[page] = questions.length - count;
            }
        }
    }
}

class PaperRightPanel extends JPanel implements MouseListener {
    private final MainFrame mainFrame;
    private final PaperPanel paperPanel;
    private final JButton endExam;
    private final TestTimerLabel timerLabel;
    private final ImageIcon endExamD = new ImageIcon("src/Student/Resource/endExamD.png");
    private final ImageIcon endExamU = new ImageIcon("src/Student/Resource/endExamU.png");
    private final UploadPaperDialog uploadDialog = new UploadPaperDialog();

    public PaperRightPanel(PaperPanel paperPanel) {
        this.mainFrame = paperPanel.getMainFrame();
        this.paperPanel = paperPanel;
        setBounds(1300, 0, 300, 860);
        setLayout(null);
        setBackground(new Color(255, 253, 250));


        endExam = new JButton(endExamU);
        endExam.setBounds(50, 500, 200, 75);
        endExam.setFocusPainted(false);
        endExam.addMouseListener(this);
        add(endExam);

        JButton nextPage = new JButton("下一页");
        nextPage.setFont(new Font("宋体", Font.PLAIN, 20));
        nextPage.setFocusPainted(false);
        nextPage.setFocusable(false);
        nextPage.setBounds(50, 600, 100, 37);
        add(nextPage);
        nextPage.addActionListener(e -> paperPanel.getPaperLeftPanel().nextPage());

        JButton prePage = new JButton("上一页");
        prePage.setFont(new Font("宋体", Font.PLAIN, 20));
        prePage.setFocusPainted(false);
        prePage.setFocusable(false);
        prePage.setBounds(100, 600, 100, 37);
        add(prePage);
        prePage.addActionListener(e -> paperPanel.getPaperLeftPanel().prePage());


        JLabel remainTime = new JLabel("剩余时间：");
        remainTime.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        remainTime.setBounds(50, -30, 200, 200);
        add(remainTime);


        timerLabel = new TestTimerLabel(paperPanel, 2, 0, 0);
        add(timerLabel);
        timerLabel.setBounds(50, 20, 200, 200);
        java.util.Timer timer = new Timer();
        timer.schedule(timerLabel.getTimeTask(), 0, 1000);


        setVisible(true);
    }

    public UploadPaperDialog getUploadPaperDialog() {
        return uploadDialog;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        uploadDialog.setVisible(true);
        if (uploadDialog.getResult() == 1) {
            timerLabel.getTimeTask().cancel();
            mainFrame.examEnd(paperPanel);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        endExam.setIcon(endExamD);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        endExam.setIcon(endExamU);
    }
}

class PaperJSP extends JScrollPane {
    public PaperJSP(PaperLeftPanel paperLeftPanel) {
        super(paperLeftPanel, VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_NEVER);
        setBounds(0, 0, 1300, 860);
        JScrollBar bar = getVerticalScrollBar();
        bar.setUnitIncrement(20);
        bar.setUI(new MyScrollBarUI(17));
        javax.swing.SwingUtilities.invokeLater(() -> bar.setValue(0));
    }

}

class PaperLeftPanel extends JPanel {
    private final PagesPanel[] pagesPanels;
    private int page = 0;

    public PaperLeftPanel(PagesPanel[] pagesPanels) {
        this.pagesPanels = pagesPanels;
        pagesPanels[page].setVisible(true);
    }

    public void jumpPage(int jump) {
        if (jump >= 0 && jump < pagesPanels.length) {
            page = jump;
            for (int i = 0; i < pagesPanels.length; i++) {
                pagesPanels[i].setVisible(i == jump);
            }
        }
    }

    public void nextPage() {
        pagesPanels[page].setVisible(false);
        if (page < pagesPanels.length - 1)
            page++;
        pagesPanels[page].setVisible(true);
    }

    public void prePage() {
        pagesPanels[page].setVisible(false);
        if (page > 0)
            page--;
        pagesPanels[page].setVisible(true);
    }

    public String[] getAnswer(){
        String[] answer = new String[4];
        String[] choiceAnswer = pagesPanels[0].getChoiceAnswer();
        String[] multiAnswer = pagesPanels[0].getMultiChoiceAnswer();
        String[] judgeAnswer = pagesPanels[0].getJudgeAnswer();
        String[] subjectiveAnswer = pagesPanels[0].getSubjectiveAnswer();
        for (int i=1;i<pagesPanels.length;i++){
            int choiceLength = choiceAnswer.length;
            String[] tempChoice = pagesPanels[i].getChoiceAnswer();
            choiceAnswer = Arrays.copyOf(choiceAnswer,choiceLength+tempChoice.length);
            System.arraycopy(tempChoice,0,choiceAnswer,choiceLength,tempChoice.length);

            int multiLength = multiAnswer.length;
            String[] tempMulti = pagesPanels[i].getMultiChoiceAnswer();
            multiAnswer = Arrays.copyOf(multiAnswer,multiLength+tempMulti.length);
            System.arraycopy(tempMulti,0,multiAnswer,multiLength,tempMulti.length);

            int judgeLength =judgeAnswer.length;
            String[] tempJudge = pagesPanels[i].getJudgeAnswer();
            judgeAnswer = Arrays.copyOf(judgeAnswer,judgeLength+tempJudge.length);
            System.arraycopy(tempJudge,0,judgeAnswer,judgeLength,tempJudge.length);

            int subjectiveLength = subjectiveAnswer.length;
            String[] tempSubjective = pagesPanels[i].getSubjectiveAnswer();
            subjectiveAnswer = Arrays.copyOf(subjectiveAnswer,subjectiveLength+tempSubjective.length);
            System.arraycopy(tempSubjective,0,subjectiveAnswer,subjectiveLength,tempSubjective.length);
        }
        answer[0]=JSON.toJSONString(choiceAnswer);
        answer[1]=JSON.toJSONString(multiAnswer);
        answer[2]=JSON.toJSONString(judgeAnswer);
        answer[3]=JSON.toJSONString(subjectiveAnswer);

        return answer;
    }
}

class PagesPanel extends JPanel {
    private int count = 1;
    private final ArrayList<ChoicePanel> choicePanels = new ArrayList<>();
    private final ArrayList<MultiChoicePanel> multiChoicePanels = new ArrayList<>();
    private final ArrayList<JudgePanel> judgePanels = new ArrayList<>();
    private final ArrayList<SubjectivePanel> subjectivePanels = new ArrayList<>();

    public PagesPanel() {
        setLayout(new GridBagLayout());
        setVisible(false);
    }

    public void addChoiceQuestions(Question_Choice[] questions) {
        for (int i = 0; i < questions.length; i++) {
            choicePanels.add(new ChoicePanel(questions[i],count));
            add(choicePanels.get(i));
        }
    }

    public void addMultiChoiceQuestions(Question_MultiChoice[] questions) {
        for (int i = 0; i < questions.length; i++) {
            multiChoicePanels.add(new MultiChoicePanel(questions[i],count));
            add(multiChoicePanels.get(i));
        }
    }

    public void addJudgeQuestions(Question_Judge[] questions) {
        for (int i = 0; i < questions.length; i++) {
            judgePanels.add(new JudgePanel(questions[i],count));
            add(judgePanels.get(i));
        }
    }

    public void addSubjectiveQuestions(Question_Subjective[] questions) {
        for (int i = 0; i < questions.length; i++) {
            subjectivePanels.add(new SubjectivePanel(questions[i],count));
            add(subjectivePanels.get(i));
        }
    }

    public String[] getChoiceAnswer(){
        String[] answers = new String[choicePanels.size()];
        for (int i=0;i<answers.length;i++){
            answers[i]=choicePanels.get(i).getAnswer();
        }
        return answers;
    }

    public String[] getMultiChoiceAnswer(){
        String[] answers = new String[multiChoicePanels.size()];
        for (int i=0;i<answers.length;i++){
            answers[i]=multiChoicePanels.get(i).getAnswer();
        }
        return answers;
    }
    public String[] getJudgeAnswer(){
        String[] answers = new String[multiChoicePanels.size()];
        for (int i=0;i<answers.length;i++){
            answers[i]=judgePanels.get(i).getAnswer();
        }
        return answers;
    }
    public String[] getSubjectiveAnswer(){
        String[] answers = new String[multiChoicePanels.size()];
        for (int i=0;i<answers.length;i++){
            answers[i]=subjectivePanels.get(i).getAnswer();
        }
        return answers;
    }

    public Component add(Component comp) {
        super.add(comp, new GBC(0, count, 0, 1).setFill(GridBagConstraints.BOTH).setInsets(10));
        count++;
        return comp;
    }
}
