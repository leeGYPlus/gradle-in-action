package com.lee;

class ProjectVersion {
    Integer major
    Integer minor
    Boolean release

    ProjectVersion(Integer major, Integer minor) {
        this.major = major
        this.minor = minor
        this.release = Boolean.FALSE
    }

    ProjectVersion(Integer major, Integer minor, Boolean release) {
        this(major, minor)
        this.release = release
    }


    @Override
    public String toString() {
        return "ProjectVersion{" +
                "major=" + major +
                ", minor=" + minor +
                ", release=" + release +
                '}';
    }
}
