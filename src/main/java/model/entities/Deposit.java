package model.entities;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Deposit implements Externalizable {
    private String name;
    private Bank bank;
    private int minSum;
    private int term;
    private double percent;
    private boolean isPretermWithdraw;
    private boolean isReplenish;

    public Deposit() {

    }

    public Deposit(String name, Bank bank, int minSum, int term, double percent,
                   boolean isPretermWithdraw, boolean isReplenish) {
        this.name = name;
        this.bank = bank;
        this.minSum = minSum;
        this.term = term;
        this.percent = percent;
        this.isPretermWithdraw = isPretermWithdraw;
        this.isReplenish = isReplenish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinSum() {
        return minSum;
    }

    public void setMinSum(int minSum) {
        this.minSum = minSum;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public boolean isPretermWithdraw() {
        return isPretermWithdraw;
    }

    public void setPretermWithdraw(boolean pretermWithdraw) {
        isPretermWithdraw = pretermWithdraw;
    }

    public boolean isReplenish() {
        return isReplenish;
    }

    public void setReplenish(boolean replenish) {
        isReplenish = replenish;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Банк: " + bank.getName() + ", депозит: " + name + "\n"
                + "Мин. сумма = " + minSum + " грн., срок - " + term + " мес." + "\n"
                +  "Ставка - " + percent + "%\n" + "Досрочное снятие - "
                + (isPretermWithdraw ? "да":"нет") + ", пополнение - "
                + (isReplenish? "да":"нет") + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Deposit other = (Deposit) obj;
        return this.name.equals(other.name)
                && bank.getName().equals(other.bank.getName())
                && this.minSum == other.minSum
                && this.term == other.term
                && !(this.percent != other.percent)
                && this.isPretermWithdraw == other.isPretermWithdraw
                && this.isReplenish == other.isReplenish;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(minSum);
        out.writeInt(term);
        out.writeDouble(percent);
        out.writeBoolean(isPretermWithdraw);
        out.writeBoolean(isReplenish);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        minSum = in.readInt();
        term = in.readInt();
        percent = in.readDouble();
        isPretermWithdraw = in.readBoolean();
        isReplenish = in.readBoolean();
    }
}
