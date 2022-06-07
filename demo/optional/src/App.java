import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws Exception {
        // Khởi tạo Optional empty
        Optional<String> optionalEmpty = Optional.empty();
        System.out.println("optionalEmpty : " + optionalEmpty);

        System.out.println("optionalEmpty isEmpty : " + optionalEmpty.isEmpty());
        System.out.println("optionalEmpty isPresent : " + optionalEmpty.isPresent());

        // Khởi tạo 1 đối tượng option String
        Optional<String> message = Optional.of("Xin chào");
        System.out.println("message" + message);

        // Lấy ra dữ liệu của optional
        System.out.println("Value of message = " + message.get());
        
        System.out.println("message isEmpty : " + message.isEmpty());
        System.out.println("message isPresent : " + message.isPresent());

        // Khởi tạo 1 đối tượng Optional null
        // Sử dụng ofNullable : 
        // Nếu Object != null -> trả về Optional<T>
        // Ngược lại trả về Optional Empty
        Optional<String> nullValue = Optional.ofNullable(null);
        System.out.println(nullValue);
        // Không có giá trị nên không thể get
        // System.out.println(nullValue.get());
        
        System.out.println(nullValue.isEmpty());
        System.out.println(nullValue.isPresent());

        // IfPresenst------------
        List<Integer> number = Arrays.asList(1,2,3,4,5);
        Optional<List<Integer>> optionalNumber = Optional.of(number);
        optionalNumber.ifPresent(n -> {
            for (Integer ele : n) {
                System.out.println(ele);
            }
        });

        optionalNumber.ifPresentOrElse(n -> {
            for (Integer ele : n) {
                System.out.println(ele);
            }
        }, () -> System.out.println("Không có gì cả"));

        optionalEmpty.ifPresentOrElse(
            str -> System.out.println(str), 
            () -> System.out.println("Không có gì cả")
        );
    }
}
