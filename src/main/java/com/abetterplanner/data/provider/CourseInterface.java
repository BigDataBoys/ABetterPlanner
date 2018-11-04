package com.abetterplanner.data.provider;

import java.util.ArrayList;
import java.util.List;

public interface CourseInterface<E> {

    /**
     * @return the name
     */
    public String getName();

    /**
     * @return the description
     */
    public String getDescription();

    /**
     *
     * @return
     */
    public boolean isCompleted();

    /**
     *
     * @return
     */
    public List<E> getPrerequisites();

    /**
     *
     * @param name
     */
    public void setName(String name);

    /**
     *
     * @param description
     */
    public void setDescription(String description);

    /**
     *
     * @param course
     */
    public void setPrerequisite(E course);

    /**
     *
     * @param course
     */
    public void setPrerequisites(ArrayList<E> course);

    /**
     *
     * @param completed
     */
    public void setCompleted(boolean completed);
}
