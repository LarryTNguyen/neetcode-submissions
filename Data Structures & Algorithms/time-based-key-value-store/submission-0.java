class TimeMap {

    HashMap<String, List<TimeValue>> keyVal;
    public TimeMap() {
        keyVal = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        keyVal.putIfAbsent(key, new ArrayList<>());
        keyVal.get(key).add(new TimeValue(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(keyVal.get(key) == null) return "";
        List<TimeValue> timeArr = keyVal.get(key);
        int left = 0;
        int right = timeArr.size()-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(timeArr.get(mid).time == timestamp) return timeArr.get(mid).value;
            else if(timeArr.get(mid).time > timestamp) right = mid -1;
            else left = mid+1;
        }
        if(left-1 == -1) return "";
        return timeArr.get(left-1).value;
    }
}

class TimeValue{
    int time;
    String value;

    public TimeValue(int time, String value){
        this.time = time;
        this.value = value;
    }
}
