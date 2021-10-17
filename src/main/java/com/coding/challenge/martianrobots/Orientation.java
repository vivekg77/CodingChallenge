package com.coding.challenge.martianrobots;

public enum Orientation {
    N,
    E,
    S,
    W;

    //This method will give the orientation based on the clockwise movement of the robot from its
    //previous orientation
    public static Orientation rotatingClockwise(Orientation o) {

        switch(o) {
            case N: return E;
            case E: return S;
            case S: return W;
            case W: return N;
        }

        return null;
    }

    //This method will give the orientation based on the anti-clockwise movement of the robot from its
    //previous orientation
    public static Orientation rotatingAntiClockwise(Orientation o) {

        switch(o) {
            case N: return W;
            case E: return N;
            case S: return E;
            case W: return S;
        }

        return null;
    }
}
