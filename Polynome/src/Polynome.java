public class Polynome {

    private double[] polynome;

    //Polynome constructors
    public Polynome(double[] polynome) {
        this.polynome = new double[polynome.length];
        for (int index = 0; index < polynome.length; index++){
            this.polynome[index] = polynome[index];
        }
    }
    public Polynome(String polynome){
        definePolynome(polynome);
        int stringIndex = polynome.length();
        int index = 0;
        while (index < stringIndex){
            String element = "";
            while ((polynome.charAt(index) != '+' || polynome.charAt(index) != '-') && index < stringIndex){
                element += polynome.charAt(index);
                index++;
            }
            addToPolynome(element);
            index++;
        }

    }

    //Polynome from String constructor helpers
    public void definePolynome(String polynome){
        int lastIndex = polynome.length();
        int index = 0;
        String size = "";
        boolean foundX = false;
        while (polynome.charAt(index) != 'x' && index < lastIndex){
            index++;
            if (polynome.charAt(index) == 'x'){
                foundX = true;
            }
        }
        if (index == lastIndex && foundX){
            this.polynome = new double[2];
        }else if(index == lastIndex && !foundX){
            this.polynome = new double[1];
        }
        if (polynome.charAt(++index) != ' '){
            if (polynome.charAt(index) == '^'){
                index++;
            }
            while(polynome.charAt(index) != ' '){
                size += polynome.charAt(index);
                index++;
            }
        }else{
            size += "1";
        }

        this.polynome = new double[Integer.parseInt(size)+1];
    }
    public void addToPolynome(String element){
        int size = element.length();
        int index = 0;
        String num = "";
        String pos = "";
        while (element.charAt(index) != 'x' && index < size){
            if (element.charAt(index) == ' ' || element.charAt(index) == '+'){
                continue;
            }
            num += element.charAt(index);
            index++;
        }
        if (index < size) {
            index++;
            num = ((num == "") ? "1" : num);
            if (element.charAt(index) == '^') {
                index++;
                while (element.charAt(index) != ' ') {
                    pos += element.charAt(index);
                    index++;
                }
            } else {
                pos = "1";
            }
        }else{
            pos = "0";
        }
        polynome[Integer.parseInt(pos)] = Double.parseDouble(num);

    }

    //Polynome to String method
    public String toString(){
        String result = "";
        for (int index = 0; index < polynome.length; index++){
            if (polynome[index] != 0){
                if (polynome[index] > 0){
                    result += "+";
                }
                result += Double.toString(polynome[index]) + "x^" + Integer.toString(index);
            }
        }
        return result;
    }

    //Polynome plus Array/String/Polynome methods
    public void add(double[] polynome){
        int maxSize;
        maxSize = this.polynome.length > polynome.length? this.polynome.length : polynome.length;
        for (int index = 0; index < maxSize; index++){
            if (this.polynome.length == maxSize){
                if(polynome.length > index) {
                    this.polynome[index] += polynome[index];
                }else{
                    break;
                }
            }else{
                if (this.polynome.length > index) {
                    polynome[index] += this.polynome[index];
                }else{
                    break;
                }
            }
        }
        if (this.polynome.length < maxSize){
            this.polynome = new double[maxSize];
            for (int index = 0; index < maxSize; index++){
                this.polynome[index] = polynome[index];
            }
        }

    }
    public void add(String polynome){
        Polynome pol = new Polynome(polynome);
        add(pol);
    }
    public void add(Polynome polynome){
        add(polynome.polynome);
    }

    //Polynome substract Array/String/Polynome methods
    public void minus(double[] polynome){
        for (int index = 0; index < polynome.length; index++){
            polynome[index] *= -1;
        }
        add(polynome);
    }
    public void minus(String polynome){
        Polynome pol = new Polynome(polynome);
        add(pol);
    }
    public void minus(Polynome polynome){
        minus(polynome.polynome);
    }


    //Polynome multiplying Array/String/Polynome methods
    public void multiply(double[] polynome){
        int size = this.polynome.length + polynome.length;
        double[] result = new double[size];
        for (int index = 0; index < this.polynome.length; index++){
            for (int pos = 0; pos < polynome.length; pos++){
                result[index+pos] = this.polynome[index] * polynome[pos];
            }
        }
        this.polynome = new double[size];
        for (int index = 0; index < size; index++){
            this.polynome[index] = result[index];
        }
    }
    public void multiply(String polynome){
        Polynome pol = new Polynome(polynome);
        multiply(pol);
    }
    public void multiply(Polynome polynome){
        multiply(polynome.polynome);
    }
}