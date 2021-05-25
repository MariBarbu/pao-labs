package com.company;

public class Warder extends Employee{
   private static int hazardPay = 100;

   public Warder() {
      super();
   }

   public Warder(int id, String name, int hours, String birthDate, int library_id) {
      super(id, name, hours, birthDate, library_id);
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
