import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<User> users = new ArrayList<>();
        users.add(new User("Bùi Hiên", 25, "hien@techmaster.vn"));
        users.add(new User("Nguyễn Bích Ngọc", 23, "ngoc@gmail.com"));
        users.add(new User("Nguyễn Thu Hằng", 27, "hang@gmail.com"));
        users.add(new User("Bùi Phương Loan", 16, "loan@gmail.com"));
        users.add(new User("Nguyễn Minh Duy", 30, "duy@gmail.com"));
        users.add(new User("Lã Ngọc Huyền", 18, "huyen@gmail.com"));

        // Count => đếm số lượng bản ghi
        System.out.println(users.stream().count());

        // forEach
        users.stream()
            .forEach(p -> System.out.println(p));

        // map
        users.stream()
            .map(p -> p.getName())
            .forEach(p -> System.out.println(p));

        // filter
        users.stream()
            .filter(p -> p.getAge() > 25)
            .forEach(p -> System.out.println(p));

        // findAny - findFirst
        System.out.println(users.stream().findAny().get());
        System.out.println(users.stream().findFirst().get());

        // sum
        System.out.println(users.stream().mapToInt(u -> u.getAge()).average().getAsDouble());

        // allMatch = every
        System.out.println(users.stream().allMatch(p -> p.getAge() > 25));
        System.out.println(users.stream().allMatch(p -> p.getAge() < 40));

        // anyMatch = some
        System.out.println(users.stream().anyMatch(p -> p.getAge() > 25));
        System.out.println(users.stream().anyMatch(p -> p.getAge() > 40));
    }
}
