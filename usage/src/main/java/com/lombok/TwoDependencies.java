package com.lombok;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.pojos.NoDependency;
import com.pojos.NoFields;

import java.util.List;

public class TwoDependencies {
    NoDependency noDependency;
    List<NoFields> noFieldsList;

    TwoDependencies(NoDependency noDependency, List<NoFields> noFieldsList) {
        this.noDependency = noDependency;
        this.noFieldsList = noFieldsList;
    }

    public static com.lombok.TwoDependencies.TwoDependenciesBuilder builder() {
        return new com.lombok.TwoDependencies.TwoDependenciesBuilder();
    }

    public static class TwoDependenciesBuilder {
        private NoDependency noDependency;
        private List<NoFields> noFieldsList;

        TwoDependenciesBuilder() {
        }

        public com.lombok.TwoDependencies.TwoDependenciesBuilder noDependency(NoDependency noDependency) {
            this.noDependency = noDependency;
            return this;
        }

        public com.lombok.TwoDependencies.TwoDependenciesBuilder noFieldsList(List<NoFields> noFieldsList) {
            this.noFieldsList = noFieldsList;
            return this;
        }

        public com.lombok.TwoDependencies build() {
            return new com.lombok.TwoDependencies(this.noDependency, this.noFieldsList);
        }

        public String toString() {
            return "TwoDependencies.TwoDependenciesBuilder(noDependency=" + this.noDependency + ", noFieldsList=" + this.noFieldsList + ")";
        }
    }
}

