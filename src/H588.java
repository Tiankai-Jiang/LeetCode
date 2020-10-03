import java.util.*;
public class H588 {

    class File{
        String name;
        String content;

        public File(String name){
            this.name = name;
            this.content = "";
        }

        private void append(String newContent){
            content = content.concat(newContent);
        }
    }

    class Directory{
        String name;
        Map<String, Directory> subdirs;
        Map<String, File> files;

        public Directory(String name){
            this.name = name;
            subdirs = new HashMap<>();
            files = new HashMap<>();
        }

        private List<String> ls(){
            List<String> res = new ArrayList<>();
            for(Directory dir: subdirs.values()) res.add(dir.name);
            for(File f: files.values()) res.add(f.name);
            Collections.sort(res);
            return res;
        }

        private Directory cd(String name){
            return subdirs.get(name);
        }

        private Directory mkdir(String name){
            subdirs.put(name, new Directory(name));
            return subdirs.get(name);
        }
    }

    Directory root = new Directory("/");

    public List<String> ls(String path) {
        if(path.equals("/")) return root.ls();
        Directory cur = cd(path);
        String fileName = path.substring(path.lastIndexOf("/")+1);
        if(cur.files.containsKey(fileName)) return new ArrayList<String>(){{add(fileName);}};
        else return cur.subdirs.get(fileName).ls();
    }

    public void mkdir(String path) {
        Directory cur = root;
        String[] paths = path.substring(1).split("/");
        int i;
        for(i=0; i< paths.length; i++){
            if(cur.subdirs.containsKey(paths[i])) cur = cur.cd(paths[i]);
            else break;
        }
        for(;i< paths.length; i++) cur = cur.mkdir(paths[i]);
    }

    public void addContentToFile(String filePath, String content) {
        Directory cur = cd(filePath);
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        cur.files.putIfAbsent(fileName, new File(fileName));
        cur.files.get(fileName).append(content);
    }

    private Directory cd(String path){
        Directory cur = root;
        if(path.equals("/")) return cur;
        String[] paths = path.substring(1).split("/");
        int l = paths.length;
        for(int i=0; i<l-1; i++) cur = cur.cd(paths[i]);
        return cur;
    }

    public String readContentFromFile(String filePath) {
        Directory cur = cd(filePath);
        String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
        return cur.files.get(fileName).content;
    }
}
