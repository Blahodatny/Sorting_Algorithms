import helpers.CSV;
import helpers.Helper;
import sort.Sort;

class Main {
    public static void main(String... args) {
        var list = new CSV().readFile("students.csv");

        var studentArray = Helper.convertToStudentArray(list);
        System.out.println("Selection sort of array\nBefore sorting:");
        Helper.print(studentArray);
        Sort.selection(studentArray);
        System.out.println("\nAfter sorting:");
        Helper.print(studentArray);

        var studentList = Helper.convertToStudentList(list);
        System.out.println("\n\nInsertion sort of list\nBefore sorting:");
        Helper.print(studentList);
        System.out.println("\nAfter sorting:");
        Helper.print(Sort.insertion(studentList));
    }
}