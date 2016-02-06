package gamepack;

//unmodified since git


public class Loot {
	
	//drop chances based on player stats and weapon power based on stats
	//public loot(player stats here to influence weapon drops
	
	public Object chooseLootDrop(int override,Player lootlessPlayer){
		//override chooses which kind to choose specifically
		int chooseWeaponPotion = (int)(1+(Math.random()*2));
		if(override>0){chooseWeaponPotion = override;}
		
		if(chooseWeaponPotion == 1){
			return potionGenerator(0);
		}
		else{
			return weaponGenerator(0, lootlessPlayer);
		}
	}
	
	public Potion potionGenerator(){
			int chooseRandomItem = (int)(1+(Math.random()*8));
			return potionGenerator(chooseRandomItem);
		}
		
	public Potion potionGenerator(int override){
			//override chooses specifically which potion, with a default of <0
			
			//if(override>0){chooseRandomItem = override;}
				
			//item types: - health potion (heals health) - elixir (heals power) - up power, down evade - up speed, down evade - up evade, down health
			//potion class type, level, print statement, locked in percentage increase/decrease	
					
			//health power speed evade qty name
			switch(override){
				//potions are percentage based, ex) 10 health -> health potion 1.5x -> results in 5 health recovered to 15
				case 1: Potion health = new Potion(1.5,1,1,1,1,"Health Potion");
						return health;
				
				case 2: Potion power = new Potion(1,1.5,1,1,1,"Power Potion");
						return power;
					
				case 3: Potion speed = new Potion(1,1,1.5,1,1,"Speed Potion");
						return speed;
					
				case 4: Potion evade = new Potion(1,1,1,1.5,1,"Evade Potion");
						return evade;
				
				//  decreases speed and increases health
				case 5: Potion fortitude = new Potion(2,1,.5,1,1,"Fortitude Potion");
						return fortitude;

				//  decreases evasion and increases power
				case 6: Potion rage = new Potion(1,2,1,.5,1,"Rage Potion");
						return rage;
				
				//  decreases health and increases evasion
				case 7: Potion thinning = new Potion(.5,1,1,2,1,"Thinning Potion");
						return thinning;
				
				//  decrease power and increase speed
				case 8: Potion fleeting = new Potion(1,.5,2,1,1,"Fleeting Potion");
						return fleeting;
				default:
					return new Potion(0,0,0,0,0,"zero potion");
			}
		}
	
//PREFIX/title generator for weapons
		public String weaponPrefixGenerator(){
			int chooseRandomPrefix = (int)(1+(Math.random()*8));
			return weaponPrefixGenerator(chooseRandomPrefix);
		}
		
		public String weaponPrefixGenerator(int override){
			switch(override){
			//1-4 increase multiple Weapon attributes
			//5-8 increase Weapon attributes
			case 1:return "The Great ";//increase Weapon damage and criticalChance
			case 2:return "The Powerful ";//increase Weapon criticalChance and special
			case 3:return "The Everlasting ";//increase Weapon accuracy and damage
			case 4:return "The Calm ";//increase Weapon accuracy and special
			
			case 5:return "The Mighty ";//increase Weapon damage
			case 6:return "The Masterful ";//increase Weapon accuracy
			case 7:return "The Lucky ";//increase Weapon criticalChance
			case 8:return "The Efficient ";//increase Weapon special (power drain per use, higher special mean higher efficiency)
			
			default:
				return "";//no prefix
			}
			
		}
		
//SUFFIX generator for weapons
		public String weaponSuffixGenerator(){
					int chooseRandomSuffix = (int)(1+(Math.random()*8));
					return weaponSuffixGenerator(chooseRandomSuffix);
				}
				
		public String weaponSuffixGenerator(int override){
					switch(override){
					//1-4 increase multiple Weapon attributes
					//5-8 increase and decrease Weapon attributes
					case 1:return " of the Storm";//increase Weapon damage and criticalChance
					case 2:return " of Precision";//increase Weapon damage and accuracy
					case 3:return " of Proficiency";//increase Weapon damage and special (power drain per use, higher special mean higher efficiency)
					case 4:return " of Tranquility";//increase Weapon accuracy and special (power drain per use, higher special mean higher efficiency)
					
					case 5:return " of Blind Strength";//greatly increases Weapon damage and decreases accuracy
					case 6:return " of Waste";//greatly increases Weapon criticalChance and lowers special
					case 7:return " of Skill";//greatly increases Weapon special and lowers damage
					case 8:return " of Poisoned Fortitude";//significantly (significantly>greatly) increases weapon damage and significantly lowers criticalChance
					
					default:
						return "";//no Suffix
					}
					
				}
		
		public Weapon weaponGenerator(Player weaponlessPlayer){
			int chooseRandomWeapon = (int)(1+(Math.random()*5));
			return weaponGenerator(chooseRandomWeapon,weaponlessPlayer);
		}

		public Weapon weaponGenerator(int override,Player weaponlessPlayer){
			
			//prefix and suffix creation + effect controller
			double damage=1,accuracy=1,criticalChance=1,special=1;
			String weaponPrefix = weaponPrefixGenerator();
			//8 possible cases for prefixes
						if(weaponPrefix.equals("The Great ")){ damage *= 1.5;criticalChance *= 1.5;  }
				else	if(weaponPrefix.equals("The Powerful ")){ criticalChance *= 1.5;special *= 1.5;  }
				else    if(weaponPrefix.equals("The Everlasting ")){accuracy *= 1.5;damage *= 1.5;  }
				else	if(weaponPrefix.equals("The Calm ")){ accuracy *= 1.5;special *= 1.5;  }
						
				else	if(weaponPrefix.equals("The Mighty ")){ damage *= 1.5;  }
				else	if(weaponPrefix.equals("The Masterful ")){ accuracy *= 1.5;  }
				else	if(weaponPrefix.equals("The Lucky ")){ criticalChance *= 1.5;  }
				else	if(weaponPrefix.equals("The Efficient ")){ special *= 1.5;  }
						//if none selected, then will pass through
			String weaponSuffix = weaponSuffixGenerator();
						if(weaponSuffix.equals(" of the Storm")){ damage *= 1.5;criticalChance *= 1.5;  }
				else	if(weaponSuffix.equals(" of Precision")){ damage *= 1.5;accuracy *= 1.5;  }
				else	if(weaponSuffix.equals(" of Proficiency")){ damage *= 1.5;special *= 1.5;  }
				else	if(weaponSuffix.equals(" of Tranquility")){ accuracy *= 1.5;special *= 1.5;  }
						
				else	if(weaponSuffix.equals(" of Blind Strength")){ damage *= 2.0;accuracy *= 0.5;  }
				else	if(weaponSuffix.equals(" of Waste")){ criticalChance *= 2.0;special *= 0.5;  }
				else	if(weaponSuffix.equals(" of Skill")){ special *= 2.0;damage *= .5;  }
				else	if(weaponSuffix.equals(" of Poisoned Fortitude")){ damage *= 3;criticalChance *= 0.25;  }
						//if none selected, then will pass through
			
			double playerPowerUse = weaponlessPlayer.powerGetter();
			
			playerPowerUse = Math.pow(playerPowerUse,.7);
			//curve: y=x^0.7
			//reason: at 250 base power, resulting weapon increase will be 50  weapon damage
			//		  at 700 base power, resulting weapon increase will be 100 weapon damage
			//		 at 2000 base power, resulting weapon increase will be 200 weapon damage
			//for balance; will be multiplied by weapon base damage in addition to prefixes/suffixes
			
			//double damage, double accuracy, double criticalChance, double special, String type	
			//special = power drain to use weapon
			//default power regen for player
			//override works the same, if >0 then it will choose which case specifically
			
				//staff, wand, tome, scroll, summon
				//if(override>0){chooseRandomMageWeapon = override;}
				
				//base weapon attack will use 100 power. Special of 130 will be 30% efficiency, reducing usage to 70
				
				
				//playerPowerUse counts how many places >= ones digit(ie. 1234.345 will return 4 digits >= ones digit and divides by 100; so 4 becomes .04 and subtracted from efficiency
				String playerPowerUseCount = Double.toString(playerPowerUse);
				int countDigits = 0;
				for(int i = 0;i<playerPowerUseCount.length();i++){
					if(playerPowerUseCount.charAt(i) == ('.')){
						break;
					}
					else{
						countDigits++;
					}
				}
				countDigits/=10;
				//count digits is subtracted from special b/c high power reduces efficiency slowly
				
				//weapons:  5-20 damage
				//			.9-1 accuracy
				//			.1-.5 criticalChance
				//			.75-1.4 special
				if(weaponlessPlayer.charTypeGetter().equals("Mage")){
	    //MAGE			
				switch(override){
				case 1: Weapon staff = new Weapon(15*damage*playerPowerUse,.96*accuracy,0.2*criticalChance,(1.1*special)-countDigits,weaponPrefix+" Staff "+weaponSuffix);
					return staff;
				case 2: Weapon wand = new Weapon(12*damage*playerPowerUse,.99*accuracy,0.3*criticalChance,(1.2*special)-countDigits,weaponPrefix+" Wand "+weaponSuffix);
					return wand;
				case 3: Weapon tome = new Weapon(20*damage*playerPowerUse,.90*accuracy,0.15*criticalChance,(0.8*special)-countDigits,weaponPrefix+" Tome "+weaponSuffix);
					return tome;
				case 4: Weapon scroll = new Weapon(5*damage*playerPowerUse,.999*accuracy,0.35*criticalChance,(1.4*special)-countDigits,weaponPrefix+" Scroll "+weaponSuffix);
					return scroll;
				case 5: Weapon summon = new Weapon(7*damage*playerPowerUse,.95*accuracy,0.5*criticalChance,(0.85*special)-countDigits,weaponPrefix+" Summon "+weaponSuffix);
					return summon;
				default:
					break;
				}
			}
		//WARRIOR
			else if(weaponlessPlayer.charTypeGetter().equals("Warrior")){
				//axe, dagger, mace, spear, sword
				
				switch(override){
				case 1: Weapon axe = new Weapon(12*damage*playerPowerUse,.999*accuracy,0.1*criticalChance,(1.4*special)-countDigits,weaponPrefix+" Axe "+weaponSuffix);
					return axe;
				case 2: Weapon dagger = new Weapon(6*damage*playerPowerUse,.90*accuracy,0.6*criticalChance,(1.5*special)-countDigits,weaponPrefix+" Dagger "+weaponSuffix);
					return dagger;
				case 3: Weapon mace = new Weapon(10*damage*playerPowerUse,.99*accuracy,0.25*criticalChance,(1.2*special)-countDigits,weaponPrefix+" Mace "+weaponSuffix);
					return mace;
				case 4: Weapon spear = new Weapon(17*damage*playerPowerUse,.90*accuracy,0.5*criticalChance,(.9*special)-countDigits,weaponPrefix+" Spear "+weaponSuffix);
					return spear;
				case 5: Weapon sword = new Weapon(14*damage*playerPowerUse,.95*accuracy,0.3*criticalChance,(1*special)-countDigits,weaponPrefix+" Sword "+weaponSuffix);
					return sword;
				default:
					break;
				}
			}
			
			else { //archer last possible case	
		//ARCHER
				
				//shortbowbow, longbow, crossbow, Throwing Knife, Throwing Axe
				
				switch(override){
				case 1: Weapon shortbow = new Weapon(10*damage*playerPowerUse,.999*accuracy,0.2*criticalChance,(1.3*special)-countDigits,weaponPrefix+" Shortbow "+weaponSuffix);
					return shortbow;
				case 2: Weapon longbow = new Weapon(20*damage*playerPowerUse,.90*accuracy,0.2*criticalChance,(.9*special)-countDigits,weaponPrefix+" Longbow "+weaponSuffix);
					return longbow;
				case 3: Weapon crossbow = new Weapon(15*damage*playerPowerUse,.95*accuracy,0.2*criticalChance,(1.15*special)-countDigits,weaponPrefix+" Crossbow "+weaponSuffix);
					return crossbow;
				case 4:	Weapon throwingKnife = new Weapon(7*damage*playerPowerUse,.97*accuracy,0.5*criticalChance,(1.2*special)-countDigits,weaponPrefix+" Throwing Knife "+weaponSuffix);
					return throwingKnife;
				case 5: Weapon javelin = new Weapon(12*damage*playerPowerUse,.93*accuracy,0.35*criticalChance,(1*special)-countDigits,weaponPrefix+" Javelin "+weaponSuffix);
					return javelin;
				default:
					break;
				}
			}
			return new Weapon(0,0,0,0,"Blade of Zero");		
		}
}