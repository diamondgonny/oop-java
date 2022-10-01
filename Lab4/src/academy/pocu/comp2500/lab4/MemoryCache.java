package academy.pocu.comp2500.lab4;

import java.util.HashMap;
import java.util.LinkedList;

public class MemoryCache {
    // static and non-static
    private static HashMap<String, MemoryCache> instanceMap = new HashMap<>();
    private static LinkedList<String> instanceList = new LinkedList<>();
    private static int maxInstanceCount = Integer.MAX_VALUE;
    private EvictionPolicy evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    private HashMap<String, String> entryMap = new HashMap<>();
    private LinkedList<String> entryListAddedOrder = new LinkedList<>();
    private LinkedList<String> entryListUsedOrder = new LinkedList<>();
    private int maxEntryCount = Integer.MAX_VALUE;

    private MemoryCache() {
    }

    public static MemoryCache getInstance(String myHardDiskName) {
        if (instanceMap.containsKey(myHardDiskName) == false) {
            instanceMap.put(myHardDiskName, new MemoryCache());
            instanceList.addFirst(myHardDiskName);
            MemoryCache.removeExceedingMaxInstance();
        } else {
            instanceList.remove(myHardDiskName);
            instanceList.addFirst(myHardDiskName);
        }
        return instanceMap.get(myHardDiskName);
    }

    public static void clear() {
        instanceList.clear();
        instanceMap.clear();
    }

    public static void setMaxInstanceCount(int maxInstanceCount) {
        MemoryCache.maxInstanceCount = maxInstanceCount;
        MemoryCache.removeExceedingMaxInstance();
    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    public void addEntry(String key, String value) {
        if (entryMap.containsKey(key) == false) {
            entryMap.put(key, value);
            entryListAddedOrder.addFirst(key);
            entryListUsedOrder.addFirst(key);
            this.removeExceedingMaxEntry(1);
        } else {
            entryMap.put(key, value);
            entryListUsedOrder.remove(key);
            entryListUsedOrder.addFirst(key);
        }
    }

    public String getEntryOrNull(String key) {
        if (entryMap.containsKey(key) == false) {
            return null;
        } else {
            entryListUsedOrder.remove(key);
            entryListUsedOrder.addFirst(key);
            return entryMap.get(key);
        }
    }

    public void setMaxEntryCount(int maxEntryCount) {
        this.maxEntryCount = maxEntryCount;
        this.removeExceedingMaxEntry(0);
    }

    private static void removeExceedingMaxInstance() {
        int index;
        String key = null;
        while (instanceMap.size() > maxInstanceCount) {
            index = instanceList.size() - 1;
            key = instanceList.get(index);
            instanceList.remove(index);
            instanceMap.remove(key);
        }
    }

    private void removeExceedingMaxEntry(int targetIndexOfLifo) {
        int index;
        String key = null;
        while (entryMap.size() > maxEntryCount) {
            if (this.evictionPolicy == EvictionPolicy.FIRST_IN_FIRST_OUT) {
                index = entryListAddedOrder.size() - 1;
                key = entryListAddedOrder.get(index);
                entryListAddedOrder.remove(index);
                entryListUsedOrder.remove(key);
            } else if (this.evictionPolicy == EvictionPolicy.LAST_IN_FIRST_OUT) {
                index = targetIndexOfLifo;
                key = entryListAddedOrder.get(index);
                entryListAddedOrder.remove(key);
                entryListUsedOrder.remove(key);
            } else if (this.evictionPolicy == EvictionPolicy.LEAST_RECENTLY_USED) {
                index = entryListUsedOrder.size() - 1;
                key = entryListUsedOrder.get(index);
                entryListUsedOrder.remove(index);
                entryListAddedOrder.remove(key);
            } else {
                assert (false) : "Unknown case evictionPolicy in 'removeExceedingMaxEntry' method";
            }
            entryMap.remove(key);
        }
    }
}
