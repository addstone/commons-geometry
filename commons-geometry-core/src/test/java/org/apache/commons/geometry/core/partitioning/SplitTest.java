/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.geometry.core.partitioning;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SplitTest {

    @Test
    public void testProperties() {
        // arrange
        final Object a = new Object();
        final Object b = new Object();

        // act
        final Split<Object> split = new Split<>(a, b);

        // assert
        Assertions.assertSame(a, split.getMinus());
        Assertions.assertSame(b,  split.getPlus());
    }

    @Test
    public void testGetLocation() {
        // arrange
        final Object a = new Object();
        final Object b = new Object();

        // act/assert
        Assertions.assertEquals(SplitLocation.NEITHER, new Split<>(null, null).getLocation());
        Assertions.assertEquals(SplitLocation.MINUS, new Split<>(a, null).getLocation());
        Assertions.assertEquals(SplitLocation.PLUS, new Split<>(null, b).getLocation());
        Assertions.assertEquals(SplitLocation.BOTH, new Split<>(a, b).getLocation());
    }

    @Test
    public void testToString() {
        // arrange
        final Split<String> split = new Split<>("a", "b");

        // act
        final String str = split.toString();

        // assert
        Assertions.assertEquals("Split[location= BOTH, minus= a, plus= b]", str);
    }
}
