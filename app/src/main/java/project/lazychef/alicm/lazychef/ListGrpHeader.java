package project.lazychef.alicm.lazychef;

/**
 * Created by alicm on 06/02/2017.
 */

public class ListGrpHeader {
    String title;
    int imageResource;

    public ListGrpHeader(String titulo, int imageResource){
        this.title = titulo;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titulo) {
        this.title = titulo;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }




}
