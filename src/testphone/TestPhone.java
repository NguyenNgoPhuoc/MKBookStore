/* 1) Tạo class Phone : String phoneId,phoneName,Supplier;
                        int price;
     - tạo hàm dựng khởi tạo trị các biến null và 0 tương ứng.
     - tạo hàm dựng có tham số
     - override hàm toString() để xuất thông tin của Phone.
    2) Tạo class PhoneDAL :
        -khai báo HashMap<K,V> để chứa thông tin của các phone.
        - viết hàm addNew() : nhận chi tiết của phone và thêm vào arraylist.
         Ghi chú : phoneId, phoneName, Supplier không được để trống.
                   price phải >0.
       - viết hàm dispay() : để xuất toàn bộ thông tin của phone trong arraylist
       - viết hàm Save() : để ghi lại thông tin phone vào file tên Phone.txt
       vào ổ đĩa tùy ý.
     3) class TestPhone chứa hàm main() với menu sau :
             1.Add new     2.Display    3.SaveFile   4.Exit hiển thị
Khi nhấn Exit để thoát chương trình, tự động mở notepad hiển thị nội dung
file Phone.txt
 
 */
package testphone;

import java.util.Scanner;

/**
 *
 * @author nguye
 */
public class TestPhone {
    public static void main(String[] args) {
      int choice=0;
        Scanner sc = new Scanner(System.in);
        PhoneDAL<String,Phone> p = new PhoneDAL<String,Phone>();
        do {            
            System.out.println("|1.Add Phone|2.DisplayAll|3.SaveFile|4.SearchName|5.Exit");
            System.out.print("Choice:");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Phone phone = p.addPhone();
                    //đưa vào hashmap
                    p.put(phone.getPhoneId(), phone);
                    break;
                case 2:
                    p.displayAll();
                    break;
                case 3:
                    p.SaveFile();
                    break;
                case 4:
                    System.out.print("Enter phone name to search: ");
                    String name = sc.nextLine();
                    p.search(name);
                    break;
                case 5:
                    System.out.println("Bye");
                    System.exit(0);
                default:
                    System.out.println("Wrong choice!!!Enter [1-2-3-4]");
            }
        } while (choice!=5);
    }
    
}
