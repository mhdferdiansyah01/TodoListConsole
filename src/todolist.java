import java.sql.SQLOutput;

public class todolist {

    public static String [] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();

    }

    // Business Logic
    public static void showTodoList(){
        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var no = i + 1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }

    }

    // test showTodoList

    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar Study Case Java Dasar";
        showTodoList();
    }



    public static void addTodoList(String todo){

        // Resize Array yang defaultny 10, agar bisa menyesuaikan dengan length yang akan di gunakan selanjutnya
        // Sebelum resize, harus melakukan pengecekan dulu apakah sudah full
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null){
                // Array masih ada yang koosong
                isFull = false;
                break;
            }
        }

        // jika penuh atau issFull true, akan diresize array nya 2 x model.length

        if (isFull){
            var temp = model;
            model = new String[model.length * 2]; // jika dgn seperti ini saja, array yang sebelum nya akan hilang

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];

            }
        }

        // Add data ke index yang Null
        for (int i = 0; i < model.length ; i++) {
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList(){
        for (int i = 0; i < 25 ; i++) {
            addTodoList("Contoh Todo Ke." + i);

        }

        showTodoList();
    }


    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }

    }

    public static void testRemoveTodoList(){
        addTodoList("Satu"); // index 0
        addTodoList("Dua"); // index 1
        addTodoList("Tiga"); // index 2

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(4); // index 3, harusnya false karena index 3 null
        System.out.println(result);

        result = removeTodoList(2); // remove index 1, yakni data No,2 "Dua"
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var alamat = input("Alamat");
        System.out.println("Alamat Anda :"+ " "+ alamat);
    }


    // View
    public static void viewShowTodoList(){
        while (true) {
            showTodoList();

            System.out.println("MENU :");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")){
                break;
             }else{
                System.out.println("Pilihan Tidak Dimengerti");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        viewShowTodoList();
    }

    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODO LIST");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {

        }else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODO LIST");

        var number = input("Nomor yang Dihapus (x jika batal)");
        if(number.equals("x")){
            // cancel
        }else{
            boolean success = removeTodoList(Integer.valueOf(number)); //konversi String to Integer
            if (!success){
                System.out.println("Gagal menghapus TODO LIST : " + number);
            }
        }

    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }


}

