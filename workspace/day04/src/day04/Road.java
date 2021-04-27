package day04;

public class Road {
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks();
		gangnam.register(new Cafe() {
			
			@Override
			public void sell(String menu) throws Exception{
				String[] arMenu = getMenu();
				boolean isOk = false;
				for(int i =0; i<arMenu.length;i++) {
					if(arMenu[i].equals(menu)) {
						isOk = true;
					}
				}
				if(!isOk) {throw new Exception();}
			}
			
			@Override
			public int[] getPrice() {
				int[] arPrice = {3000,4000};
				return arPrice;
			}
			
			@Override
			public String[] getMenu() {
				String[] arMenu = {"아메리카노","카푸치노"};
				return arMenu;
		}
		});
		
		Starbucks jamsil = new Starbucks();
		jamsil.register(new CafeAdapter() {
			@Override
			public String[] getMenu() {
				String[] arMenu = {"아메리카노","카푸치노"};
				return arMenu;
			}
		});
	}
}