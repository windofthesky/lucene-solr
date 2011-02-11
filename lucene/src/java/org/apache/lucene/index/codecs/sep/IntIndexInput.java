package org.apache.lucene.index.codecs.sep;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Closeable;
import java.io.IOException;

import org.apache.lucene.store.DataInput;
import org.apache.lucene.index.BulkPostingsEnum;

// nocommit -- move to oal.store?

/** Defines basic API for reading blocks of ints.  SepCodec
 *  interacts with this API.
 *
 * @lucene.experimental */
public abstract class IntIndexInput implements Closeable {

  public abstract BulkPostingsEnum.BlockReader reader() throws IOException;

  public abstract void close() throws IOException;

  public abstract Index index() throws IOException;
  
  public abstract static class Index {

    public abstract void read(DataInput indexIn, boolean absolute) throws IOException;

    /** Seeks primary stream to the last read offset.
     *  Returns true if the seek was "within block", ie
     *  within the last read block, at which point you
     *  should call {@link
     *  BulkPostingsEnum.BlockReader#offset} to know where
     *  to start from.  If this returns false, you must call
     *  {@link BulkPostingsEnum.BlockReader#fill} to read
     *  the buffer. */ 
    public abstract void seek(BulkPostingsEnum.BlockReader stream) throws IOException;

    public abstract void set(Index other);
    
    @Override
    public abstract Object clone();
  }
}
