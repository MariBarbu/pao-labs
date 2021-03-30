package com.company;

public class Warder extends Employee{
   private static int hazardPay = 100;

   public Warder() {
      super();
   }

   public Warder(String name, int hours, String birthDate, Library library) {
      super(name, hours, birthDate, library);
   }

   public static int getHazardPay() {
      return hazardPay;
   }

   public static void setHazardPay(int hazardPay) {
      Warder.hazardPay = hazardPay;
   }

   @Override
   public String toString() {
      return super.toString() + " Hazard Pay = " + hazardPay;
   }
}
