package Model;

/*
 * @author Alroy
 */
public class Files {
    private String filename;
    private String path;
    private float size;
    private String owner;
    private String share;
    
    /*public Files(String filename, String path, float size, String owner){
        this.filename = filename;
        this.path = path;
        this.size = size;
        this.owner = owner;
    }
    */
    public Files(){
        
    }
    
    public String getFilename(){
        return this.filename;
    }
    public String getPath(){
        return this.path;
    }
    
    public float getSize(){
        return this.size;
    }
    
    public String getOwner(){
        return this.owner;
    }
    
    public String getShare(){
        return this.share;
    }
    
    public void setFilename(String filename){
        this.filename = filename;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public void setSize(float size){
        this.size = size;
    }
    
    public void setOwner(String owner){
        this.owner = owner;
    }
    
    public void setShare(String share){
        this.share = share;
    }
}
