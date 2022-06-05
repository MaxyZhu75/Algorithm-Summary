class FileSystem {
    Map<String,FileSystem> hashRecord; // �������ļ�ϵͳʵ�壡����
    StringBuilder fileContent; // �ļ����ݣ�StringBuilder����������ݣ�����
    String name; // ���ļ�ϵͳ���ƣ�����
    boolean isFile; // ����һ���ļ�ϵͳ���ļ������ļ��У�����
    
	public FileSystem() { // ���캯��������
        this.hashRecord = new HashMap<>();
        fileContent = new StringBuilder();
		name = "/"; // rootĿ¼������
    }
    
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
		FileSystem fileSystem = searchAndCreate(path);	
        if (fileSystem.isFile) { // case1�������ļ����ƣ�����
			result.add(fileSystem.name);
        } else {
			for (String file : fileSystem.hashRecord.keySet()) { // case2�������ļ����������ļ����ļ������ƣ�����
                result.add(file);
            }
			Collections.sort(result); // �ֵ������У�����
		}
        return result;
    }
    
    public void mkdir(String path) { // ���ݸ�����·������һ����Ŀ¼������
        searchAndCreate(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        FileSystem fileSystem = searchAndCreate(filePath);
        fileSystem.isFile = true; // ���Ϊ�ļ�������
        fileSystem.fileContent.append(content); // StringBuilder׷���ı�������
    }
    
    public String readContentFromFile(String filePath) { // �û������ȡ�����ڵ��ļ������ݣ�����
        FileSystem fileSystem = searchAndCreate(filePath);
        return fileSystem.fileContent.toString();
    }

    public FileSystem searchAndCreate(String path){ // ����·���𲽽����ļ�ϵͳ�����������򴴽������շ���·��ָ�����ļ�ϵͳ������
        if("/".equals(path)){ // rootĿ¼������
            return this;
        }
        FileSystem current = this;
		int n = path.length();
        String[] sections = path.substring(1, n).split("/");
        for(String section : sections){
            if (!current.hashRecord.containsKey(section)){ // �����ڸ��ļ�ϵͳ�򴴽������ϣ������
				current.hashRecord.put(section, new FileSystem());
			}
            FileSystem fileSystem = current.hashRecord.get(section);
            fileSystem.name = section; // Ϊ�ļ�ϵͳ����������
            current = fileSystem; // ����ò㣡����
        }
        return current;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */