import model.User;

public class Main {
    public static void main(String[] args) {
        Person person = Person.builder().name("Hiên").build();
        System.out.println(person);

        Person person1 = Person.builder().name("Nguyễn Văn A").age(24).email("a@gmail.com").build();
        System.out.println(person1);

        Person person2 = Person.builder()
                .isMarried(true)
                .age(34)
                .name("Ngô B")
                .email("b@gmail.com")
                .phone("010192929")
                .build();
        System.out.println(person2);

        User user = new User();

        System.out.println("Một ngyaf nào đó với anh không còn buồn nữa đâu " +
                "mà là một ngày buồn nhất của cả anh và cả em trong đó anh " +
                "không còn lại nhưng gì mà anh có thể làm với em được nữa nên" +
                " xin");
    }
}
