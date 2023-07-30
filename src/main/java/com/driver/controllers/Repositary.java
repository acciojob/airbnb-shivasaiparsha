package com.driver.controllers;
import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;


import java.util.*;
public class Repositary {

    HashMap<String, Hotel> hotelDB = new HashMap<>();
    HashMap<Integer, User> userDb = new HashMap<>();

    HashMap<String, Booking> bookingdb = new HashMap<>();
      public String add(Hotel h)
      {
          String hname = h.getHotelName();
          if(hname.equals(null)) return "Failure";
         else if(hotelDB.containsKey(hname))
          {
              return "FAILURE";
          }

          hotelDB.put(hname, h);
          return "SUCCESS";
      }

      public Integer addUserTODB(User u)
      {
          Integer adhar = u.getaadharCardNo();

          userDb.put(adhar, u);

          return adhar;
      }

      public String getHotel()
      {
          int maxSize=0;
          String hotelName="";
          for(String name : hotelDB.keySet())
          {
              Hotel h = hotelDB.get(name);
              List<Facility> flist=h.getFacilities();
              if(flist.size()>maxSize)
              {
                  maxSize= flist.size();
                  hotelName=name;
              }
              else if(flist.size()==maxSize)
              {

                  char c1[] = name.toCharArray();


                  char c2[] = hotelName.toCharArray();

                  int i=0;
                 while(i<c1.length&&i<c2.length)
                 {
                     if(c1[i]<c2[i])
                     {
                         hotelName=name;
                     }
                     i++;
                 }
              }
          }

          return hotelName;
      }

      public int cost(Booking b, String uid)
      {
            String hname = b.getHotelName();

           Hotel h= hotelDB.get(hname);

            int wantrooms = b.getNoOfRooms();
            int availblerooms=h.getAvailableRooms();
            if(wantrooms>availblerooms)
                return -1;
            int cost=wantrooms*h.getPricePerNight();
            bookingdb.put(uid, b);
            return cost;

      }
   public int getBookingsDone(Integer aadhar)
   {
       int cnt=0;
       for(String id:bookingdb.keySet())
       {
           Integer aadhar1 = bookingdb.get(id).getBookingAadharCard();
           if(aadhar1==aadhar)
           {
               cnt++;
           }
       }
       return cnt;
   }

   public Hotel getHotelWithNewFacilities(List<Facility> flist, String hname)
   {
         List<Facility> facilities = hotelDB.get(hname).getFacilities();

           for(Facility f : flist)
           {
               if(!facilities.contains(f))
               {
                   facilities.add(f);
               }

           }
         Hotel fh=hotelDB.get(hname);
           return fh;
   }

}
