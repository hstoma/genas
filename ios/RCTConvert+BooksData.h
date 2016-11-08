//
//  RCTConvert+BooksData.h
//  genas
//
//  Created by Henadzi Stoma on 11/4/16.
//  Copyright © 2016 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "RCTConvert.h"
#import "SimpleItemObject.h"



@interface RCTConvert (BooksData)
+ (BooksData *) BooksData:(id)json;
@end
