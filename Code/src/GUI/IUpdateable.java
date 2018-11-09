package GUI;

import Map.GraphicObject;
import Map.Map;

public interface IUpdateable
{
    void update(Map map);

    void destroyMe(Map map);


}
