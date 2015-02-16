package codeReuse;

import java.io.File;
import java.util.ArrayList;

public class AllTest {
	public static void main(String[] args) throws Exception{
		AllTest all = new AllTest();
		all.deleteGitBefore(new File(Constants.DATA_DIR));
		all.deleteIndexBefore(new File(Constants.INDEX_DIR));
		
		GithubCodeDownloader GCD = new GithubCodeDownloader();
//		GCD.downloadCodeInOrganizations();
		GCD.downloadCodeInURL("https://github.com/choisangchul/test.git");
		
		IdentifierMiner IM = new IdentifierMiner();
		IM.ParseAllFiles(Constants.DATA_DIR);
		IM.closeIndexWriter();
		
	}
	
	private void deleteIndexBefore(File pre){
		File[] files = pre.listFiles();
		for(int i = 0; i<files.length; i++){
			File file = files[i];
			if(file.isDirectory()){
				deleteIndexBefore(file);
			}
			else{
				file.delete();
			}
		}
	}
	
	private void deleteGitBefore(File pre){
		File[] files = pre.listFiles();
		for(int i = 0; i<files.length; i++){
			File file = files[i];
			if(file.isDirectory()){
				deleteGitBefore(file);
				file.delete();
			}
			else{
				file.delete();
			}
		}
	}
}
