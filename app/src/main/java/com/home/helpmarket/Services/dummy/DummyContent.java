package com.home.helpmarket.Services.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 4;

    static {
        addItem(new DummyItem(false, "Lau nhà", null));
        addItem(new DummyItem(false, "Dọn nhà", null));
        addItem(new DummyItem(false, "Vệ sinh nhà cửa", null));
        addItem(new DummyItem(false, "...", null));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public boolean isSelected;
        public final String content;
        public final String details;

        public DummyItem(boolean isSelected, String content, String details) {
            this.isSelected = isSelected;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
