package academy.pocu.comp2500.lab4;

import java.util.HashMap;
import java.util.LinkedList;

public class MemoryCache {
    // 아래에서 static, non-static인 멤버변수의 차이?
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
        // 인스턴스 신규 등록 or 기존 등록
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
        instanceMap.clear();       // 하위 항목들도 clear 처리? (cf. 메모리누수?)
    }

    public static void setMaxInstanceCount(int maxInstanceCount) {
        MemoryCache.maxInstanceCount = maxInstanceCount;
        MemoryCache.removeExceedingMaxInstance();
    }

    // private 메서드는 맨 아래로
    private static void removeExceedingMaxInstance() {
        while (instanceMap.size() > maxInstanceCount) {
            int lastIndex = instanceList.size() - 1;
            String key = instanceList.get(lastIndex);
            instanceList.remove(lastIndex);
            instanceMap.remove(key);
        }
    }


    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        switch(this.evictionPolicy) {
            case FIRST_IN_FIRST_OUT:
                // -
                break;
            case LAST_IN_FIRST_OUT:
                // -
                break;
            case LEAST_RECENTLY_USED:
                // -
                break;
            default:
                assert (false) : "Unknown case evictionPolicy in 'setEvictionPolicy' method";
                break;
        }
    }

    public void addEntry(String key, String value) {
        // 키-값 쌍을 캐시에 추가
        // 캐시에 이미 키가 존재한다면 그 키에 연결된 값을 업데이트
        // 캐시 속에 저장된 항목수가 최대 허용치를 넘으면 현재 사용 중인 캐시 퇴거 정책에 따라 항목 하나를 제거
        if (entryMap.containsKey(key) == false) {
            entryMap.put(key, value);
            entryListAddedOrder.addFirst(key);
            entryListUsedOrder.addFirst(key);
            // this.removeExceedingMaxEntry();
            // FIFO LIFO LRU
        } else {
            entryListUsedOrder.remove(key);
            entryListUsedOrder.addFirst(key);
        }
    }

    public String getEntryOrNull(String key) {
        return entryMap.get(key);
    }

    public void setMaxEntryCount(int maxEntryCount) {
        // 현재 캐시에 저장되어 있는 항목수가 최대 허용치보다 크다면, 사용중인 캐시 퇴거 정책에 따라 초과분 제거
        this.maxEntryCount = maxEntryCount;
        this.removeExceedingMaxEntry();
    }

    // private 메서드는 맨 아래로
    private void removeExceedingMaxEntry() {
        while (entryMap.size() > maxEntryCount) {
            int lastIndex = entryList.size() - 1;
            String key = instanceList.get(lastIndex);
            instanceList.remove(lastIndex);
            instanceMap.remove(key);
        }
    }

}
