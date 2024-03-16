/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by 
 * the Free Software Foundation; either version 2.1 of the License, or 
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public 
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License 
 * along with this library; if not, write to the Free Software Foundation, 
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 * 
 * ---------------------------------------
 * StandardCategoryItemLabelGenerator.java
 * ---------------------------------------
 * (C) Copyright 2004, 2005, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: StandardCategoryItemLabelGenerator.java,v 1.2 2005/05/19 15:43:00 mungady Exp $
 *
 * Changes
 * -------
 * 11-May-2004 : Version 1 (DG);
 * 20-Apr-2005 : Renamed StandardCategoryLabelGenerator 
 *               --> StandardCategoryItemLabelGenerator (DG);
 */

package org.jfree.chart.labels;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;

import org.jfree.data.category.CategoryDataset;
import org.jfree.util.PublicCloneable;

/**
 * A standard label generator that can be used with a 
 * {@link org.jfree.chart.renderer.category.CategoryItemRenderer}.
 */
public class StandardCategoryItemLabelGenerator 
    extends AbstractCategoryItemLabelGenerator 
    implements CategoryItemLabelGenerator, Cloneable, PublicCloneable,
               Serializable {

    /** For serialization. */
    private static final long serialVersionUID = 3499701401211412882L;
    
    /** The default format string. */
    public static final String DEFAULT_LABEL_FORMAT_STRING = "{2}";
    
    /**
     * Creates a new generator with a default number formatter.
     */
    public StandardCategoryItemLabelGenerator() {
        super(DEFAULT_LABEL_FORMAT_STRING, NumberFormat.getInstance());
    }

    /**
     * Creates a new generator with the specified number formatter.
     *
     * @param labelFormat  the label format string (<code>null</code> not 
     *                     permitted).
     * @param formatter  the number formatter (<code>null</code> not permitted).
     */
    public StandardCategoryItemLabelGenerator(String labelFormat, 
                                              NumberFormat formatter) {
        super(labelFormat, formatter);
    }
    
    /**
     * Creates a new generator with the specified date formatter.
     *
     * @param labelFormat  the label format string (<code>null</code> not 
     *                     permitted).
     * @param formatter  the date formatter (<code>null</code> not permitted).
     */
    public StandardCategoryItemLabelGenerator(String labelFormat, 
                                              DateFormat formatter) {
        super(labelFormat, formatter);
    }
    
    /**
     * Generates the label for an item in a dataset.  Note: in the current 
     * dataset implementation, each row is a series, and each column contains 
     * values for a particular category.
     *
     * @param dataset  the dataset (<code>null</code> not permitted).
     * @param row  the row index (zero-based).
     * @param column  the column index (zero-based).
     *
     * @return The label (possibly <code>null</code>).
     */
    public String generateLabel(CategoryDataset dataset, int row, int column) {
        return generateLabelString(dataset, row, column);
    }
    
}
