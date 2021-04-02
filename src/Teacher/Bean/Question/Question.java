package Teacher.Bean.Question;

/*
    参数：
    stem 题干
    kind 分类
*/
public abstract class Question {
    String stem;
    int kind;
    abstract String getStem();
    abstract String getQuestion();

}

