package dk.nicolajpedersen.raidaid.Data;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.UUID;

/**
 * Created by Nicolaj on 13-03-2015.
 */
public class Appointment implements Comparator<Appointment>{
    private GregorianCalendar date;
    private Clan clan;
 //   private ArrayList<User> readyppl;
    private String headline, description;


    public Appointment (JSONObject jsonAppoint){
        try {
            date.setTimeInMillis(jsonAppoint.getLong("Date"));
            clan = Profile.getClanByID(UUID.fromString(jsonAppoint.getString("ClanID")));
            headline = jsonAppoint.getString("Headline");
            description = jsonAppoint.getString("Descripstion");

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }


    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

/*    public ArrayList<User> getReadyppl() {
        return readyppl;
    }

    public void setReadyppl(ArrayList<User> readyppl) {
        this.readyppl = readyppl;
    }
*/

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compare(Appointment lhs, Appointment rhs) {
        return lhs.getDate().compareTo(rhs.getDate());
    }
}
