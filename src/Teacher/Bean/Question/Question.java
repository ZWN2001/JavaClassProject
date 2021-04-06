package Teacher.Bean.Question;

/*
    参数：
    stem 题干
    kind 分类
    mark 分值
    qid 题号
*/
public abstract class Question {
    String stem;
    int mark;
    int qid;
    int kind;
    abstract String getStem();
    abstract String getQuestion();
    abstract int getMark();
    abstract int getQid();
    abstract int getKind();

}

