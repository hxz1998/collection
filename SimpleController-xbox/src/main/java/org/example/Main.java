package org.example;

import com.github.strikerx3.jxinput.XInputAxes;
import com.github.strikerx3.jxinput.XInputButtons;
import com.github.strikerx3.jxinput.XInputComponents;
import com.github.strikerx3.jxinput.XInputDevice;
import com.github.strikerx3.jxinput.exceptions.XInputNotLoadedException;

/**
 * Default (Template) Project
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/6/5
 **/

public class Main {
    public static void main(String[] args) throws XInputNotLoadedException {

        // Retrieve all devices
        XInputDevice[] devices = XInputDevice.getAllDevices();

        // Retrieve the device for player 1
        XInputDevice device = XInputDevice.getDeviceFor(0); // or devices[0]

        // First we need to poll data.
        // poll() will return false if the device is not connected
        if (device.poll()) {
            // Retrieve the components
            XInputComponents components = device.getComponents();

            XInputButtons buttons = components.getButtons();
            XInputAxes axes = components.getAxes();

            // Buttons and axes have public fields (although this is not idiomatic Java)

            // Retrieve button state
            if (buttons.a) {
                // The A button is currently pressed
            }

            // Check if Guide button is supported
            if (XInputDevice.isGuideButtonSupported()) {
                // Use it
                if (buttons.guide) {
                    // The Guide button is currently pressed
                }
            }

            // Retrieve axis state
            float acceleration = axes.rt;
            float brake = axes.lt;
        } else {
            // Controller is not connected; display a message
        }

// This is exactly the same as above
        device.poll();
        if (device.isConnected()) {
            // ...
        } else {
            // ...
        }
    }
}
