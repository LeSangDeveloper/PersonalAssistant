package android.example.demolistviewplan;

public class Work {

    private long id;
    private String title = null;
    private String date = null;
    private String time = null;
    private String location = null;

    public Work(){}

    public Work(String title, String date, String time, String location)
    {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getId()
    {
        return this.id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getDate()
    {
        return this.date;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getTime()
    {
        return this.time;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return this.location;
    }

}
