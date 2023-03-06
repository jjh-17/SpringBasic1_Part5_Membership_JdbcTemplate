package spring_basic.part5_membership_JdbcTemplate.domain;

//고객 데이터 - 아이디, 이름
public class Member {

    //변수
    private Long id;
    private String name;

    //메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}