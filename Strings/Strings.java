
public class Strings{
	public static boolean isAbecedarian(String word){
		for(int i = 1; i < word.length(); i++){
			if((word.charAt(i) - word.charAt(i-1)) < 0)
				return false;
		}
		return true;
	}
	public static boolean isDoubloon(String dword){
		dword = dword.toLowerCase();
		boolean check = true;
		for(int i = 0; i < dword.length(); i++){
			int num = 0;
			for(int j = 0; j < dword.length(); j++){
				if(dword.charAt(i) == dword.charAt(j))
				{
					num++;
				}
			}
			if(num != 2) {
				check = false;
				break;
			}
		}
		return check;
	}
	public static boolean canSpell(String tiles, String test){
		String unique = "";
		if(test.length() > tiles.length()) return false;
		for(int i = 0; i < test.length(); i++){
			char a = test.charAt(i);
			boolean uniqueFlag = false;
			if(unique.indexOf(a) == -1) {
				unique += a;
				uniqueFlag = true;
			}
			if(uniqueFlag){
					if(tiles.indexOf(a) == -1){
					return false;
				}
			}
			else{
				int index = tiles.indexOf(a);
				if(index == -1) return false;
				else{
					index = tiles.indexOf(a, index+1);
					if(index == -1) return false;
				}
			}
			
		}
		return true;
	}
	public static void main(String[] args){
		String word = "abdest";
		System.out.println(isAbecedarian(word));
		System.out.println(isDoubloon("Caucasus"));
		System.out.println(canSpell("quijibo", "jibbo"));
	}
}