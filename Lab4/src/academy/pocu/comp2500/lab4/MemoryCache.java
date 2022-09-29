package academy.pocu.comp2500.lab4;

import java.util.List;

public class MemoryCache {
    private static List<String, String> instances;
    private EvictionPolicy evictionPolicy = EvictionPolicy.LEAST_RECENTLY_USED;
    private int key;
    private int value;
    private int maxInstanceCount;

    private MemoryCache() {
    }

    public static MemoryCache getInstance(String myHardDiskName) {
        // 지정된 하드 디스크 전용 MemoryCache 인스턴스가 존재하지 않는다면 새로 생성하여 반환
        // 만약 현재 사용 중인 MemoryCache 인스턴스의 수가 최대 허용치를 넘으면 가장 오래된(LRU) 인스턴스를 제거
        // return instances;
        if
    }

    public static void clear() {
        // 모든 인스턴스 캐시 제거
        instances = null;
    }

    public void setMaxInstanceCount(int maxInstanceCount) {
        // 만약 현재 사용 중인 MemoryCache 인스턴스의 수가 최대 허용치를 넘게 되면 LRU에 기초하여 초과분을 제거
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
    }

    public String getEntryOrNull(String key) {
        return instances.get(value);
    }

    public void setMaxEntryCount(int maxEntryCount) {
        // 현재 캐시에 저장되어 있는 항목수가 최대 허용치보다 크다면, 사용중인 캐시 퇴거 정책에 따라 초과분 제거
    }

}
