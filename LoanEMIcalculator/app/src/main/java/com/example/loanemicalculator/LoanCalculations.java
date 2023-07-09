package com.example.loanemicalculator;


import java.io.Serializable;

public class LoanCalculations implements Serializable {
        double amt, rate, proc_fee,  other_fee, interest, totalpayment, emi;
        int months, type;

        public LoanCalculations(double amt,int months, int type,  double rate, double proc_fee,  double other_fee) {
            this.amt = amt;
            this.months = months;
            this.type = type;
            this.rate = rate;
            this.proc_fee = proc_fee;
            this.other_fee = other_fee;
            process();
        }

        public void process() {
            interest = (amt * rate / 100) / 12 * months;
            totalpayment = amt * interest;
            emi = totalpayment / months;
        }

        public double getAmt()
        {
            return amt;
        }
        public double getInterest()
        {
            return interest;
        }
        public double getTotalpayment()
        {
            return totalpayment;
        }
        public double getEmi()
        {
            return emi;
        }
        public int getMonths()
        {
            return months;
        }

    }

