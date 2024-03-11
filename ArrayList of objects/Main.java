import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("请输入事件ID");
            String eventID = scanner.nextLine();

            System.out.println("请输入事件名称：");
            String eventName = scanner.nextLine();

            System.out.println("请输入事件地点：");
            String eventVenue = scanner.nextLine();

            System.out.println("请输入事件日期(格式:yyyy-MM-dd）；");
            String eventDateStr = scanner.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date eventDate = formatter.parse(eventDateStr);

            Event event = new Event(eventID, eventName, eventVenue, eventDate);

            // 添加参与者
            while (true) {
                System.out.println("请输入参与者的名字（输入'quit'结束）：");
                String attendee = scanner.nextLine();
                if ("quit".equals(attendee)) {
                    break;
                }
                event.getEventAttendees().add(attendee);
            }

            // 打印事件信息
            System.out.println(event.toString());
        }
    }
}
