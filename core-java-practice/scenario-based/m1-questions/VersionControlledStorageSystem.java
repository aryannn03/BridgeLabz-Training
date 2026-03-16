import java.util.*;

class FileVersion {
    String version;
    int size;

    FileVersion(String version, int size) {
        this.version = version;
        this.size = size;
    }
}

public class VersionControlledStorageSystem {

    static Map<String, List<FileVersion>> map = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while (n-- > 0) {

            String input = sc.nextLine();
            String[] arr = input.split(" ");

            String op = arr[0];

            if (op.equals("UPLOAD")) {

                String file = arr[1];
                String version = arr[2];
                int size = Integer.parseInt(arr[3]);

                map.putIfAbsent(file, new ArrayList<>());

                boolean exists = false;

                for (FileVersion v : map.get(file)) {
                    if (v.version.equals(version)) {
                        exists = true;
                        break;
                    }
                }

                if (!exists) {
                    map.get(file).add(new FileVersion(version, size));
                }

            }

            else if (op.equals("FETCH")) {

                String file = arr[1];

                if (!map.containsKey(file)) {
                    System.out.println("File Not Found");
                    continue;
                }

                List<FileVersion> list = new ArrayList<>(map.get(file));

                Collections.sort(list, (a, b) -> {
                    if (a.size != b.size)
                        return a.size - b.size;
                    return a.version.compareTo(b.version);
                });

                for (FileVersion v : list) {
                    System.out.println(file + " " + v.version + " " + v.size);
                }
            }

            else if (op.equals("LATEST")) {

                String file = arr[1];

                if (!map.containsKey(file) || map.get(file).isEmpty()) {
                    System.out.println("File Not Found");
                    continue;
                }

                List<FileVersion> list = map.get(file);
                FileVersion v = list.get(list.size() - 1);

                System.out.println(file + " " + v.version + " " + v.size);
            }

            else if (op.equals("TOTAL_STORAGE")) {

                String file = arr[1];

                if (!map.containsKey(file)) {
                    System.out.println("File Not Found");
                    continue;
                }

                int sum = 0;

                for (FileVersion v : map.get(file)) {
                    sum += v.size;
                }

                System.out.println(file + " " + sum);
            }
        }
    }
}