package pesel;

class Pesel {

    private final String pesel;
    private final String gender;
    private int sumControl;

    Pesel(String pesel){
        if(isValidPesel(pesel)) {
            if(sumControl == 0){
                this.pesel = pesel;
                if(Long.parseLong(pesel.substring(9,10)) %2 == 0) gender = "Woman";
                else gender = "Man";
            }
            else{
                this.pesel = null;
                gender = null;
            }
        }
        else {
            this.pesel = null;
            gender = null;
        }

    }

    String getDateOfBirth(){
        String year = pesel.substring(0,2);
        String month = pesel.substring(2,4);
        String day = pesel.substring(4,6);

        Integer monthInt = Integer.parseInt(month);

        if(monthInt<=12) return day+"."+month+"."+19+year;
        else if(monthInt>=21 && monthInt<=32) { monthInt -= 20; if(monthInt<10) {return day+".0"+monthInt+"."+20+year;} else return day+"."+monthInt+"."+20+year;}
        else if(monthInt>=41 && monthInt<=52) { monthInt -= 40; if(monthInt<10) {return day+".0"+monthInt+"."+21+year;} else return day+"."+monthInt+"."+21+year;}
        else if(monthInt>=61 && monthInt<=72) { monthInt -= 60; if(monthInt<10) {return day+".0"+monthInt+"."+22+year;} else return day+"."+monthInt+"."+22+year;}
        else if(monthInt>=81 && monthInt<=92) { monthInt -= 80; if(monthInt<10) {return day+".0"+monthInt+"."+18+year;} else return day+"."+monthInt+"."+18+year;}
        return "Można dodać datę od 1800 do 2299 roku!";
    }

    String getGenderByPesel(){
        return gender;
    }

    String getPesel(){
        return pesel;
    }

    boolean isValidPesel(String pesel){
        int sum = 0;
        if(pesel.length()==11){
            for(int i=0; i<11; i++){
                Short a = Short.parseShort(pesel.substring(i,i+1));
                if(i==0 || i==4 || i==8 || i==10) sum += a;
                if(i==1 || i==5 || i==9) sum += a*3;
                if(i==2 || i==6) sum += a*7;
                if(i==3 || i==7) sum += a*9;
            }
            sumControl = sum%10;
            return true;
        }
        return false;
    }
}
