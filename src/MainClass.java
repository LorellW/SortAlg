public class MainClass {

    private static void begin(AbstractSort algSort) {

//        String[] a = StdIn.readAllStrings();
//        double currentTime = time(algSort, a);
//        assert AbstractSort.isSorted(a);
//        AbstractSort.show(a);
//        StdOut.println(currentTime);
    }

    public static double timeRandomIn(AbstractSort algSort, int n, int t){
        //algSort алгоритм сортировки T случайных массивов длинной N
        double total = 0.0;
        Double[] a = new Double[n];
        for (int i = 0; i < t; i++) {//Выполнение одного эксперимента(генерация и сортировка)
            for (int j = 0; j < n; j++) {
                a[j] = StdRandom.uniform();
            }
            total+=time(algSort,a);
        }
        return total;
    }

    private static double time(AbstractSort algSort, Comparable[] a) {
        Stopwatch timer = new Stopwatch();
        algSort.sort(a);
        return timer.elapsedTime();
    }

    private static AbstractSort algSelection(String s) {
        if (s.equals("Selection")) return new SelectionSort();
        if (s.equals("Insertion")) return new InsertionSort();
        return null;
    }

    public static void main(String[] args) {
        AbstractSort algSort;
        int n;// кол-во элементов
        int t;// кол-во тестов
        if (args.length > 2) {
            algSort = algSelection(args[0]);
            n = Integer.parseInt(args[1]);
            t = Integer.parseInt(args[2]);
            if (algSort != null) {
                double temp = timeRandomIn(algSort,n,t);
                StdOut.printf("Для %d тестов массивов из %d элементов время выполнения \n",t,n);
                StdOut.printf("алгоритма %s равно %.2f", args[0],temp);
            } else {
                StdOut.println("Неверно указан алгоритм");
            }
        }else {
            StdOut.println("Недостаточно параметров");
        }
    }

}
