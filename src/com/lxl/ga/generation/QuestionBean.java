package com.lxl.ga.generation;

import java.sql.Date;

/**
 * 问题Bean
 *
 * @author lixiaolin
 * @createDate 2016-06-22 20:17
 */
public class QuestionBean {
    /**
     * 题目id
     */
    private long id;
    /**
     * 题目类型 1-单选  2-填空 3-主观
     */
    private int type;
    /**
     * 难度系数 0.3-1之间
     */
    private double difficulty;
    /**
     * 对应知识点id
     */
    private long pointId;
    /**
     * 题干
     */
    private String stem;
    /**
     * 选项A
     */
    private String choice1;
    /**
     * 选项B
     */
    private String choice2;
    /**
     * 选项C
     */
    private String choice3;
    /**
     * 选项D
     */
    private String choice4;
    /**
     * 答案
     */
    private String answer;
    /**
     * 出题人id
     */
    private long userId;
    /**
     * 试题创建时间，默认为当前时间戳
     */
    private Date createTime;

    // 以下为补充字段，为了方便界面展示
    /**
     * 出题人姓名
     */
    private String userName;
    /**
     * 知识点名称
     *
     * @return
     */
    private String knowledgeName;

    // 补充字段，便于使用遗传算法组卷
    /**
     * 问题分数，由HR出卷时指定
     */
    private double score;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKnowledgeName() {
        return knowledgeName;
    }

    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public long getPointId() {
        return pointId;
    }

    public void setPointId(long pointId) {
        this.pointId = pointId;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateTime1() {
        return createTime.toString();
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    /**
     * 重写equals方法
     */
    public boolean equals(Object obj) {
        return this.id == ((QuestionBean) obj).id;
    }

    /**
     * 重写HashCode方法
     */
    public int hashCode() {
        return (int) (this.id + this.userId);
    }

    @Override
    public String toString() {
        return "QuestionBean{" +
                "id=" + id +
                ", type=" + type +
                ", difficulty=" + difficulty +
                ", pointId=" + pointId +
                ", stem='" + stem + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                ", choice3='" + choice3 + '\'' +
                ", choice4='" + choice4 + '\'' +
                ", answer='" + answer + '\'' +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", userName='" + userName + '\'' +
                ", knowledgeName='" + knowledgeName + '\'' +
                ", score=" + score +
                '}';
    }
}
