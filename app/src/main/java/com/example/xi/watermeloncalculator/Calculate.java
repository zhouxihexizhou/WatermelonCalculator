package com.example.xi.watermeloncalculator;

import java.math.BigDecimal;

public class Calculate {

    String str;

    public Calculate(String str){
        this.str=str;
    }

    public String calculate(){
        str=calcu(str);
        return str;
    }

    public String calcu(String s){
        try{
        while(s.indexOf("(")!=-1 && s.indexOf(")")!=-1){
            int left;
            int right;
            String front;
            String behind;
            left = s.lastIndexOf("(");
            front = s.substring(0, left);
            s = s.substring(left+1);
            right = s.indexOf(")");
            behind = s.substring(right+1);
            s = s.substring(0, right);
            s = front + calcu(s) +behind;
        }


        while(s.indexOf("^")!=-1){
            int mul = s.indexOf("^");
            int num=mul-1;
            while(num>0){
                boolean bool_plus = s.substring(num-1, num).equals("+");
                boolean bool_minus = s.substring(num-1, num).equals("-");
                boolean bool_multiply = s.substring(num-1, num).equals("×");
                boolean bool_divide = s.substring(num-1, num).equals("÷");
                boolean bool_evolution = s.substring(num-1, num).equals("√");
                if(bool_plus || bool_minus || bool_multiply || bool_divide || bool_evolution)
                    break;
                else
                    num--;
            }
            String a = s.substring(num, mul);
            if(a.substring(0, 1).equals("#")){
                a = a.substring(1);
                a = "-" + a;
            }
            BigDecimal a1 = new BigDecimal(a);
            String c = a1.multiply(a1).toString();
            if(c.substring(0, 1).equals("-")){
                c = c.substring(1);
                c = "#" + c;
            }
            s = s.substring(0, num) + c + s.substring(mul+2);
        }


        while(s.indexOf("√")!=-1){
            int evolution = s.lastIndexOf("√");
            int num=evolution+1;
            if(evolution>0){
                String p=s.substring(evolution-1, evolution);
                String sb1 = s.substring(0, evolution);
                String sb2 = s.substring(evolution);
                if(p.equals("0") || p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4")
                        || p.equals("5") || p.equals("6") || p.equals("7") || p.equals("8") || p.equals("9")){
                    s=sb1+"×"+sb2;
                    evolution++;
                    num++;
                }
            }
            while(s.substring(num).length()>1){
                boolean bool_plus = s.substring(num+1, num+2).equals("+");
                boolean bool_minus = s.substring(num+1, num+2).equals("-");
                boolean bool_multiply = s.substring(num+1, num+2).equals("×");
                boolean bool_divide = s.substring(num+1, num+2).equals("÷");
                if(bool_plus || bool_minus || bool_multiply || bool_divide)
                    break;
                else
                    num++;
            }
            String a = s.substring(evolution+1, num+1);
            if(a.substring(0, 1).equals("#")){
                return null;
            }else{
                double b = Double.valueOf(a);
                double c = Math.sqrt(b);
                s = s.substring(0, evolution) + Double.toString(c) + s.substring(num+1);
            }
        }


        while(s.indexOf("×")!=-1 || s.indexOf("÷")!=-1){
            int multiply = s.indexOf("×");
            int divide = s.indexOf("÷");
            if(multiply==-1)
                multiply=1000;
            if(divide==-1)
                divide=1000;
            if(multiply<divide){
                int front = multiply-1;
                while(front>0){
                    boolean bool_plus = s.substring(front-1, front).equals("+");
                    boolean bool_minus = s.substring(front-1, front).equals("-");
                    if(bool_plus || bool_minus)
                        break;
                    else
                        front--;
                }
                String a = s.substring(front, multiply);
                if(a.substring(0, 1).equals("#")){
                    a = a.substring(1);
                    a = "-" + a;
                }
                int behind = multiply+1;
                while(s.substring(behind).length()>1){
                    boolean bool_plus = s.substring(behind+1, behind+2).equals("+");
                    boolean bool_minus = s.substring(behind+1, behind+2).equals("-");
                    boolean bool_multiply = s.substring(behind+1, behind+2).equals("×");
                    boolean bool_divide = s.substring(behind+1, behind+2).equals("÷");
                    if(bool_plus || bool_minus || bool_multiply || bool_divide)
                        break;
                    else
                        behind++;
                }
                String b = s.substring(multiply+1, behind+1);
                if(b.substring(0, 1).equals("#")){
                    b = b.substring(1);
                    b = "-" + b;
                }
                BigDecimal a1 = new BigDecimal(a);
                BigDecimal b1 = new BigDecimal(b);
                String c = a1.multiply(b1).toString();
                if(c.substring(0, 1).equals("-")){
                    c = c.substring(1);
                    c = "#" + c;
                }
                s = s.substring(0, front) + c + s.substring(behind+1);
            }else{
                int front = divide-1;
                while(front>0){
                    boolean bool_plus = s.substring(front-1, front).equals("+");
                    boolean bool_minus = s.substring(front-1, front).equals("-");
                    if(bool_plus || bool_minus)
                        break;
                    else
                        front--;
                }
                String a = s.substring(front, divide);
                if(a.substring(0, 1).equals("#")){
                    a = a.substring(1);
                    a = "-" + a;
                }
                int behind = divide+1;
                while(s.substring(behind).length()>1){
                    boolean bool_plus = s.substring(behind+1, behind+2).equals("+");
                    boolean bool_minus = s.substring(behind+1, behind+2).equals("-");
                    boolean bool_multiply = s.substring(behind+1, behind+2).equals("×");
                    boolean bool_divide = s.substring(behind+1, behind+2).equals("÷");
                    if(bool_plus || bool_minus || bool_multiply || bool_divide)
                        break;
                    else
                        behind++;
                }
                String b = s.substring(divide+1, behind+1);
                if(b.substring(0, 1).equals("#")){
                    b = b.substring(1);
                    b = "-" + b;
                }
                if(b.equals("0")){
                    return null;
                }
                BigDecimal a1 = new BigDecimal(a);
                BigDecimal b1 = new BigDecimal(b);
                String c;
                try{
                    c = a1.divide(b1).toString();
                }catch (Exception e){
                    c = a1.divide(b1, 10, BigDecimal.ROUND_HALF_UP).toString();
                }
                if(c.substring(0, 1).equals("-")){
                    c = c.substring(1);
                    c = "#" + c;
                }
                s = s.substring(0, front) + c + s.substring(behind+1);
            }
        }


        while(s.indexOf("+")!=-1 || s.indexOf("-")!=-1){
            int plus = s.indexOf("+");
            int minus = s.indexOf("-");
            if(minus==0){
                String v = s.substring(1);
                if(v.indexOf("-")==-1)
                    minus=-1;
                else
                    minus=v.indexOf("-")+1;
            }
            if(plus==-1)
                plus=10000;
            if(minus==-1)
                minus=10000;
            if(s.substring(0, 1).equals("#")){
                s=s.substring(1);
                s="-"+s;
            }
            if(s.indexOf("-")==0 && s.lastIndexOf("-")==0 && s.indexOf("+")==-1){
                break;
            }
            if(s.substring(0, 1).equals("-")){
                s=s.substring(1);
                s="#"+s;
            }
            if(plus<minus){
                String a = s.substring(0, plus);
                if(a.substring(0, 1).equals("#")){
                    a = a.substring(1);
                    a = "-" + a;
                }
                int behind = plus+1;
                while(s.substring(behind).length()>1){
                    boolean bool_plus = s.substring(behind+1, behind+2).equals("+");
                    boolean bool_minus = s.substring(behind+1, behind+2).equals("-");
                    if(bool_plus || bool_minus)
                        break;
                    else
                        behind++;
                }
                String b = s.substring(plus+1, behind+1);
                if(b.substring(0, 1).equals("#")){
                    b = b.substring(1);
                    b = "-" + b;
                }
                BigDecimal a1 = new BigDecimal(a);
                BigDecimal b1 = new BigDecimal(b);
                String c = a1.add(b1).toString();
                if(c.substring(0, 1).equals("-")){
                    c = c.substring(1);
                    c = "#" + c;
                }
                s = c + s.substring(behind+1);
            }else{
                String a = s.substring(0, minus);
                if(a.substring(0, 1).equals("#")){
                    a = a.substring(1);
                    a = "-" + a;
                }
                int behind = minus+1;
                while(s.substring(behind).length()>1){
                    boolean bool_plus = s.substring(behind+1, behind+2).equals("+");
                    boolean bool_minus = s.substring(behind+1, behind+2).equals("-");
                    if(bool_plus || bool_minus)
                        break;
                    else
                        behind++;
                }
                String b = s.substring(minus+1, behind+1);
                if(b.substring(0, 1).equals("#")){
                    b = b.substring(1);
                    b = "-" + b;
                }
                BigDecimal a1 = new BigDecimal(a);
                BigDecimal b1 = new BigDecimal(b);
                String c = a1.subtract(b1).toString();
                if(c.substring(0, 1).equals("-")){
                    c = c.substring(1);
                    c = "#" + c;
                }
                s = c + s.substring(behind+1);
            }
        }
            if(s.indexOf(".")!=-1){
                while(s.substring(s.length()-1).equals("0") || s.substring(s.length()-1).equals(".")){
                    s = s.substring(0, s.length()-1);
                }
            }

            if(s.substring(0, 1).equals("-")){
                s = s.substring(1);
                s = "#" + s;
            }

        return s;

    } catch (Exception e){
            return "";
        }
    }
}
