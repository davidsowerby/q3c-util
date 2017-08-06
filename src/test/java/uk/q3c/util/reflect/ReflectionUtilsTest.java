/*
 * Copyright (C) 2013 David Sowerby
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package uk.q3c.util.reflect;

import org.junit.Test;

import java.io.Serializable;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class ReflectionUtilsTest {

    @Test
    public void allInterfaces() {

        // given

        // when
        Set<Class<?>> allInterfaces = ReflectionUtils.allInterfaces(Level2.class);
        // then

        assertThat(allInterfaces).containsOnly(Wiggly.class, Wobbly.class, Serializable.class);

    }

    interface Wiggly {

    }

    interface Wobbly {

    }

    static class Level0 implements Serializable {

    }

    static class Level1 extends Level0 implements Wiggly {

    }

    static class Level2 extends Level1 implements Wobbly {

    }
}
