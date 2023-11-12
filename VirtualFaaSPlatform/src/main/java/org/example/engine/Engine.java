/**
 * VirtualFaaSPlatform
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/7
 **/
package org.example.engine;

import org.example.Context;
import org.example.model.Event;

public interface Engine {

    String handle(Event event, Context context);

    void register(Event event, Context context);
}
