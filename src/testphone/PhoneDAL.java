package testphone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneDAL<K,V> {

    HashMap<K, V> hashphones;//khai bao
    String phoneid;
    String phonename;
    String supplier;
    int price;

    public PhoneDAL() {
        hashphones = new HashMap<K, V>();
    }

    public void put(K key, V value) {
        this.hashphones.put(key, value);
    }

    //hàm addPhone()
    public Phone addPhone() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Phone ID: ");
            phoneid = sc.nextLine();
            if (phoneid.isEmpty()) {
                System.out.println("Phone ID can not blank!!");               
            }
            break;
        } while (true);
        do {
            System.out.print("Phone Name: ");
            phonename = sc.nextLine();
            if (phonename.isEmpty()) {
                System.out.println("Phone ID can not blank!!");                
            }
            break;
        } while (true);
        do {
            System.out.print("Supplier: ");
            supplier = sc.nextLine();
            if (supplier.isEmpty()) {
                System.out.println("Supplier can not blank!!");                
            }
            break;
        } while (true);
        do {
            System.out.print("Price: ");
            price = Integer.parseInt(sc.nextLine());
            if (price<=0) {
                System.out.println("Price must be >0!!");                
            }
            break;
        } while (true);
        //tat ca du lieu deu hop le
        Phone phone = new Phone(phoneid, phonename, supplier, price);
        return phone;
    }
    //ham xuat thong tin phone
    public void displayAll()
    {
        System.out.println("\nTotal number of phone present in catalog: "+ hashphones.size());
        System.out.println("\n---------PHONE IN CATALOG----------\n");
        Set key = hashphones.keySet();
        Iterator it = key.iterator();
        int i =1;
        while (it.hasNext()) {
            System.out.println(hashphones.get(it.next()));
            i++;
        }
    }
    //hàm ghi file 
    public void SaveFile()
    {
        FileWriter fw =null;
        System.out.println("-----------LIST PHONE---------------");
        try {
            fw= new FileWriter("Phone.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            //tiến hành ghi dữ liệu vào file
            Set key = hashphones.keySet();
            Iterator it = key.iterator();
            while (it.hasNext()) {
                bw.write("\r"+ hashphones.get(it.next()));                
            }
            bw.flush();//đẩy toàn data trong bộ nhớ đệm ra
            bw.close();//đóng luồng
            fw.close();//đóng luồng
        } catch (Exception e) {
            e.printStackTrace();
        }
        ReadFile();
    }

    public void ReadFile() {
        Runtime r = Runtime.getRuntime();
        try {
            r.exec("notepad.exe phone.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //hàm searchName
    public void search(String name)
    {
        boolean flag= false;
        Set key = hashphones.keySet();
        System.out.println("----SEARCH RESULT------");
        System.out.printf("%1$s|%2$s|%3$s|%4$s|\n","ID","NAME","SUPPLIER","PRICE");
        for (Iterator iterator = key.iterator(); iterator.hasNext();) {
           Phone phone =(Phone) hashphones.get(iterator.next());
           if(phone.getPhoneName().equalsIgnoreCase(name))
           {
               System.out.println(" "+ phone.toString());
           }
            
        }
        if(flag){
            System.out.println("Not found!!");
        }
    }
}
