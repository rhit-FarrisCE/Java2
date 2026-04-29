package Exercize_5;

public class SortableRecord extends Record implements Comparable<SortableRecord> {
  public SortableRecord(String id, int m, int j, int e) {
    super(id, m, j, e);
  }

  @Override
  public int compareTo(SortableRecord r) {
    if (r.score_total != this.score_total) {
        return r.score_total > this.score_total ? 1 : -1;
    }
    else if (r.score_math != this.score_math) {
        return r.score_math > this.score_math ? 1 : -1;
    }
    else if (r.score_Japanese != this.score_Japanese) {
        return r.score_Japanese > this.score_Japanese ? 1 : -1;
    }
    else if (r.score_English != this.score_English) {
        return r.score_English > this.score_English ? 1 : -1;
    }
    else {
        return 0;
    }
  }
    
}
