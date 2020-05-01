package com.example.wwfonline.ui;

import android.content.res.Resources;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

public class CustomColorTemplate {

    public static final int[] Custom_material = {
            rgb("#2ecc71"), rgb("#f1c40f"), rgb("#e74c3c"), rgb("#3498db"), rgb("#ff9100"), rgb("#ff1744"), rgb("#428e92")
    };

    public static int rgb(String hex) {
        int color = (int) Long.parseLong(hex.replace("#", ""), 16);
        int r = (color >> 16) & 0xFF;
        int g = (color >> 8) & 0xFF;
        int b = (color >> 0) & 0xFF;
        return Color.rgb(r, g, b);
    }

    public static int getHoloBlue() {
        return Color.rgb(51, 181, 229);
    }

    public static int colorWithAlpha(int color, int alpha) {
        return (color & 0xffffff) | ((alpha & 0xff) << 24);
    }

    public static List<Integer> createColors(Resources r, int[] colors) {

        List<Integer> result = new ArrayList<Integer>();

        for (int i : colors) {
            result.add(r.getColor(i));
        }

        return result;
    }

    public static List<Integer> createColors(int[] colors) {

        List<Integer> result = new ArrayList<Integer>();

        for (int i : colors) {
            result.add(i);
        }

        return result;
    }
}
