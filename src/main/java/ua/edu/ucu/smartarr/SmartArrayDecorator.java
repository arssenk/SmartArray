package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    SmartArray array;

    SmartArrayDecorator(SmartArray smartArray) {
        this.array = smartArray;
    }

}
