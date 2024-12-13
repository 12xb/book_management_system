package com.system.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "works")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String workName;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private int wordCount;

    @Column(nullable = false)
    private String userPhone; // 用户的手机号，关联用户

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", workName='" + workName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", wordCount=" + wordCount +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
