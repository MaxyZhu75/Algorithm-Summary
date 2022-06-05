class FileSystem {
    Map<String,FileSystem> hashRecord; // 名称与文件系统实体！！！
    StringBuilder fileContent; // 文件内容；StringBuilder方便更改内容！！！
    String name; // 该文件系统名称！！！
    boolean isFile; // 区分一个文件系统是文件还是文件夹！！！
    
	public FileSystem() { // 构造函数！！！
        this.hashRecord = new HashMap<>();
        fileContent = new StringBuilder();
		name = "/"; // root目录！！！
    }
    
    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
		FileSystem fileSystem = searchAndCreate(path);	
        if (fileSystem.isFile) { // case1：返回文件名称！！！
			result.add(fileSystem.name);
        } else {
			for (String file : fileSystem.hashRecord.keySet()) { // case2：返回文件夹下所有文件及文件夹名称！！！
                result.add(file);
            }
			Collections.sort(result); // 字典序排列！！！
		}
        return result;
    }
    
    public void mkdir(String path) { // 根据给定的路径创建一个新目录！！！
        searchAndCreate(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        FileSystem fileSystem = searchAndCreate(filePath);
        fileSystem.isFile = true; // 标记为文件！！！
        fileSystem.fileContent.append(content); // StringBuilder追加文本！！！
    }
    
    public String readContentFromFile(String filePath) { // 用户不会获取不存在的文件的内容！！！
        FileSystem fileSystem = searchAndCreate(filePath);
        return fileSystem.fileContent.toString();
    }

    public FileSystem searchAndCreate(String path){ // 根据路径逐步进入文件系统，若不存在则创建，最终返回路径指定的文件系统！！！
        if("/".equals(path)){ // root目录！！！
            return this;
        }
        FileSystem current = this;
		int n = path.length();
        String[] sections = path.substring(1, n).split("/");
        for(String section : sections){
            if (!current.hashRecord.containsKey(section)){ // 不存在该文件系统则创建加入哈希表！！！
				current.hashRecord.put(section, new FileSystem());
			}
            FileSystem fileSystem = current.hashRecord.get(section);
            fileSystem.name = section; // 为文件系统命名！！！
            current = fileSystem; // 进入该层！！！
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